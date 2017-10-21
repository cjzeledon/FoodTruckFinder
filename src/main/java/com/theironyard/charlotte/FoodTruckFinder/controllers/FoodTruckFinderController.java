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
    FoodTruckRepository foodTruckRepo;

//    @PostConstruct
//    public void init () {
//
//        // if there are no food trucks in the repository..
//        if (foodTruckRepo.count() == 0) {
//            FoodTruck t = new FoodTruck();
//
//            t.setFoodType();
//            t.set
//            foodTruckRepo.save(t);
//        }
//    }

    // allow a user to log in if their information is found in the database
    @CrossOrigin
    @GetMapping("/signin")
    public String signIn(Model model, HttpSession session){
        if (session.getAttribute("current_user") == null){
            return "signup";
        }
        return "index";
    }

    // if the user has not created an account with the app, then allow them
    //
    @CrossOrigin
    @PostMapping("signup")
    public String signUp(@RequestBody User createdUser, HttpSession session){
        userRepo.save(createdUser);
        session.setAttribute("current_user", createdUser);
        return "/";
    }


    @CrossOrigin
    @PostMapping("/foodtruck")
    public void foodTruck (@RequestBody FoodTruck truck){

    }

}
