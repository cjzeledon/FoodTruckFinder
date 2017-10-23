package com.theironyard.charlotte.FoodTruckFinder.controllers;

import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruck;
import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruckLocation;
import com.theironyard.charlotte.FoodTruckFinder.models.database.User;
import com.theironyard.charlotte.FoodTruckFinder.repositories.FoodTruckLocationRepository;
import com.theironyard.charlotte.FoodTruckFinder.repositories.FoodTruckRepository;
import com.theironyard.charlotte.FoodTruckFinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

@RestController
public class FoodTruckFinderController {

    @Autowired
    FoodTruckRepository foodTruckRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    FoodTruckLocationRepository locationRepo;

    @PostConstruct
    public void init () {

        // if there are no food trucks in the repository..
        if (foodTruckRepo.count() == 0) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("tacos");
            t.setYelpId("tin-kitchen-charlotte-2");
            t.setName("TIN Kitchen");
            t.setImageURL("https://s3-media3.fl.yelpcdn.com/bphoto/5U3u-sZ6Vx5oV9mdBw4-Ig/o.jpg");
            foodTruckRepo.save(t);
        }
    }

    @PostConstruct
    public void fakeUser() {
        if (userRepo.count() == 0) {

            User u = new User();
            u.setEmail("fakeUser1@foodtruckfinder.com");
            u.setPassword("123");
            u.setUserName("tacoGuy");
            u.setUserType("owner");
            userRepo.save(u);
        }

        if (userRepo.count() == 1){
            User u = new User();
            u.setEmail("fakeUser2@foodtruckfinder.com");
            u.setPassword("abc");
            u.setUserName("tachoLovin");
            u.setUserType("customer");
            userRepo.save(u);
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

    @CrossOrigin
    @PostMapping("/foodtruck/add")
    public void addFoodTruck(FoodTruck truck){
        foodTruckRepo.save(truck);
    }

    @CrossOrigin
    @GetMapping("/foodtruck/all")
    public Iterable<FoodTruck> getAllFoodTrucks(){
        return foodTruckRepo.findAll();
    }

//    @CrossOrigin
//    @GetMapping("/foodtruck/all")
//    public String getAllFoodTrucks(Model model){
//        model.addAttribute("truckie", foodTruckRepo.findAll());
//    }

    @CrossOrigin
    @PatchMapping("/foodtruck/{id}")
    public void updateLocation(@RequestBody FoodTruckLocation loc,
                               @PathVariable("id") int truck_id){
        // find the food truck in question
        foodTruckRepo.findOne(truck_id);
        // save the location object
        // set the truck's location to that object
        // save the truck
    }


}
