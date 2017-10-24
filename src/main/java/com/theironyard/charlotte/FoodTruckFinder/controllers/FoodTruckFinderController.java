package com.theironyard.charlotte.FoodTruckFinder.controllers;

import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruck;
import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruckLocation;
import com.theironyard.charlotte.FoodTruckFinder.models.database.User;
import com.theironyard.charlotte.FoodTruckFinder.repositories.FoodTruckLocationRepository;
import com.theironyard.charlotte.FoodTruckFinder.repositories.FoodTruckRepository;
import com.theironyard.charlotte.FoodTruckFinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class FoodTruckFinderController {
    private final String USER_KEY = "user";

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
            t.setUrl("https://www.yelp.com/biz/tin-kitchen-charlotte-2?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(1));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 1) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("grilled cheese");
            t.setYelpId("papi-queso-charlotte");
            t.setName("Papi Queso");
            t.setImageURL("https://s3-media3.fl.yelpcdn.com/bphoto/zlq_gcqvoxY3TGVyMaPg9g/o.jpg");
            t.setUrl("https://www.yelp.com/biz/papi-queso-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(2));
            foodTruckRepo.save(t);

        }


        if (foodTruckRepo.count() == 2) {
            FoodTruck t = new FoodTruck();
            t.setFoodType("Halal");
            t.setName("Mi Barrio's Halal Cart");
            t.setYelpId("mi-barrios-halal-cart-chalotte");
            t.setImageURL("https://s3-media4.fl.yelpcdn.com/bphoto/GQMfzEetRC-WNlPRBiheMA/o.jpg");
            t.setUrl("https://www.yelp.com/biz/mi-barrios-halal-cart-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(3));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 3) {
            FoodTruck t = new FoodTruck();
            t.setFoodType("All");
            t.setName("Food Truck Friday Charlotte");
            t.setYelpId("food-truck-friday-charlotte-charlotte");
            t.setImageURL("https://s3-media3.fl.yelpcdn.com/bphoto/xUiSXQo8Dr0QV8-SiwjxyA/o.jpg");
            t.setUrl("https://www.yelp.com/biz/food-truck-friday-charlotte-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(4));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 4) {
            FoodTruck t = new FoodTruck();
            t.setFoodType("sandwiches");
            t.setName("The Cookin Coop");
            t.setYelpId("the-cookin-coop-charlotte");
            t.setImageURL("https://s3-media1.fl.yelpcdn.com/bphoto/DpOmefPgbOIoP-cJqUBlRw/o.jpg");
            t.setUrl("https://www.yelp.com/biz/the-cookin-coop-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(5));
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
            u.setFoodTruck(foodTruckRepo.findOne(1));
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

    @PostConstruct
    public void truckLocation() {
        if(locationRepo.count() == 0) {
          FoodTruckLocation l = new FoodTruckLocation();
          l.setLatitude(32.23039);
          l.setLongitude(-80.84439);
          l.setFoodTruck(foodTruckRepo.findOne(1));
          locationRepo.save(l);
        }

        if(locationRepo.count() == 1) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(35.227855682373);
            l.setLongitude(-80.8443069458008);
            l.setFoodTruck(foodTruckRepo.findOne(2));
            locationRepo.save(l);
        }

        if(locationRepo.count() == 2) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(35.21392);
            l.setLongitude(-80.85811);
            l.setFoodTruck(foodTruckRepo.findOne(3));
            locationRepo.save(l);
        }

        if(locationRepo.count() == 3) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(35.21392);
            l.setLongitude(-80.85811);
            l.setFoodTruck(foodTruckRepo.findOne(4));
            locationRepo.save(l);
        }

        if(locationRepo.count() == 4) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(35.22287);
            l.setLongitude(-80.83796);
            l.setFoodTruck(foodTruckRepo.findOne(5));
            locationRepo.save(l);
        }
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
//    @PatchMapping("/foodtruck/{id}")
//    public void updateLocation(@RequestBody FoodTruckLocation loc,
//                               @PathVariable("id") int truck_id){
//        // find the food truck in question
//        FoodTruck truck = foodTruckRepo.findOne(truck_id);
//
//        // save the location object
//        locationRepo.save(loc);
//
//        // set the truck's location to that object
//        // save the truck
//    }

    @CrossOrigin
    @PostMapping("/login")
    public void logIn(@RequestBody User user, HttpSession session, HttpServletResponse response) throws IOException {
        // Check with the database if the user has an account with the application
        User repoUser = userRepo.findFirstByUserNameAndPassword(user.getUserName(), user.getPassword());

        // If the user is found, set the current session to the user
        if (repoUser != null){
            session.setAttribute(USER_KEY, repoUser);
        } else{
            response.sendError(401, "You have not created account with this application. Please sign up.");
        }
    }

    @CrossOrigin
    @PostMapping("/signup")
    public void signUp(@RequestBody User newUser, HttpSession session, HttpServletResponse response) throws IOException {
        if (userRepo.findFirstByUserName(newUser.getUserName()) == null) {
            session.setAttribute(USER_KEY, userRepo.save(newUser));
        } else {
            // An error found when a user tries to create an account with a username that
            // already exists in the database
            response.sendError(422, "Username already exists. Please try again.");
        }
    }




}
