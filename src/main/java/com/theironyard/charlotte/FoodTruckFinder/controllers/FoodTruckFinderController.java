package com.theironyard.charlotte.FoodTruckFinder.controllers;

import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruck;
import com.theironyard.charlotte.FoodTruckFinder.models.database.User;
import com.theironyard.charlotte.FoodTruckFinder.repositories.FoodTruckRepository;
import com.theironyard.charlotte.FoodTruckFinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

@RestController
public class FoodTruckFinderController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    FoodTruckRepository foodTruckRepository;

    @PostConstruct
    public void init () {

        // if there are no food trucks in the repository..
        if (foodTruckRepository.count() == 0) {
            FoodTruck t = new FoodTruck();

            t.setFoodType("tacos");
            t.setYelpId("tin-kitchen-charlotte-2");
            t.setName("TIN Kitchen");
            t.setImageURL("https://s3-media3.fl.yelpcdn.com/bphoto/5U3u-sZ6Vx5oV9mdBw4-Ig/o.jpg");
            foodTruckRepository.save(t);
        }
    }

    @CrossOrigin
    @GetMapping("/signin")
    public String signIn(Model model, HttpSession session){
        if (session.getAttribute("current_user") == null){
            return "signup";
        }
        return "index";
    }

    @CrossOrigin
    @PostMapping("signup")
    public String signUp(@RequestBody User createdUser, HttpSession session){
        userRepo.save(createdUser);
        session.setAttribute("current_user", createdUser);
        return "/";
    }



}
