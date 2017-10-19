package com.theironyard.charlotte.FoodTruckFinder.controllers;

import com.theironyard.charlotte.FoodTruckFinder.models.database.User;
import com.theironyard.charlotte.FoodTruckFinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class FoodTruckFinderController {

    @Autowired
    UserRepository userRepo;

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
