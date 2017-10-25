package com.theironyard.charlotte.FoodTruckFinder.controllers;
import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruck;
import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruckFavorite;
import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruckLocation;
import com.theironyard.charlotte.FoodTruckFinder.models.database.User;
import com.theironyard.charlotte.FoodTruckFinder.models.database.UserType;
import com.theironyard.charlotte.FoodTruckFinder.repositories.FavoritesRepository;
import com.theironyard.charlotte.FoodTruckFinder.repositories.FoodTruckLocationRepository;
import com.theironyard.charlotte.FoodTruckFinder.repositories.FoodTruckRepository;
import com.theironyard.charlotte.FoodTruckFinder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;

@RestController
public class FoodTruckFinderController {
    private final String USER_KEY = "user";

    @Autowired
    FoodTruckRepository foodTruckRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    FoodTruckLocationRepository locationRepo;

    @Autowired
    FavoritesRepository favoritesRepo;

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

        if (foodTruckRepo.count() == 5) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("soul food");
            t.setName("Roaming Fork");
            t.setYelpId("roaming-fork-charlotte-2");
            t.setImageURL("https://s3-media2.fl.yelpcdn.com/bphoto/u2e93f8bh6AZowGAlvVdFA/o.jpg");
            t.setUrl("https://www.yelp.com/biz/roaming-fork-charlotte-2?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(6));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 6) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("seafood");
            t.setName("Maryland Crab & Co");
            t.setYelpId("maryland-crab-and-co-charlotte");
            t.setImageURL("https://s3-media1.fl.yelpcdn.com/bphoto/iRstX0a2QRu5os3eloEQhg/o.jpg");
            t.setUrl("https://s3-media1.fl.yelpcdn.com/bphoto/iRstX0a2QRu5os3eloEQhg/o.jpg");
            t.setLocation(locationRepo.findOne(7));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 7) {

            FoodTruck t = new  FoodTruck();
            t.setFoodType("pizza");
            t.setName("Vitos Pizza");
            t.setYelpId("vitos-pizza-charlotte-2");
            t.setImageURL("https://s3-media1.fl.yelpcdn.com/bphoto/oFFeiIe1JOc1IC7tqiDJAw/o.jpg");
            t.setUrl("https://www.yelp.com/biz/vitos-pizza-charlotte-2?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(8));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 8) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("thai");
            t.setName("Thai 2 go");
            t.setYelpId("thai-2-go-concord");
            t.setImageURL("https://s3-media2.fl.yelpcdn.com/bphoto/8rmMM6-SFZWkmo9sPU190A/o.jpg");
            t.setUrl("https://www.yelp.com/biz/thai-2-go-concord?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(9));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 9) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("mediterranean");
            t.setName("Fresh Med Food Truck");
            t.setYelpId("fresh-med-food-truck-charlotte");
            t.setImageURL("https://s3-media4.fl.yelpcdn.com/bphoto/ZJE3pD30Yyl-FMceu0DxvA/o.jpg");
            t.setUrl("https://www.yelp.com/biz/fresh-med-food-truck-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(10));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 10) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("tacos");
            t.setName("SoCal Taco Stand");
            t.setYelpId("socal-taco-stand-charlotte");
            t.setImageURL("https://s3-media2.fl.yelpcdn.com/bphoto/pmdhI5Nz_mNLtnbualIOiQ/o.jpg");
            t.setUrl("https://www.yelp.com/biz/socal-taco-stand-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(11));
            foodTruckRepo.save(t);
        }

            if (foodTruckRepo.count() == 11) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("comfort food");
            t.setName("Comfort Foods on Wheels");
            t.setYelpId("comfort-foods-on-wheels-charlotte");
            t.setImageURL("https://s3-media4.fl.yelpcdn.com/bphoto/7PArhaUfNT_ktIyTM53BlQ/o.jpg");
            t.setUrl("https://www.yelp.com/biz/comfort-foods-on-wheels-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(12));
            foodTruckRepo.save(t);
            }

            if (foodTruckRepo.count() == 12) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("indian");
            t.setName("Chennai Curries");
            t.setYelpId("chennia-curries-charlotte");
            t.setImageURL("https://s3-media4.fl.yelpcdn.com/bphoto/lh5-waABMQkeZKaRoM-jXA/o.jpg");
            t.setUrl("https://www.yelp.com/biz/chennai-curries-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(13));
            foodTruckRepo.save(t);
            }

            if (foodTruckRepo.count() == 13) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("acai");
            t.setName("Rico's Acai");
            t.setYelpId("ricos-acai-charlotte");
            t.setImageURL("https://s3-media1.fl.yelpcdn.com/bphoto/4lPRtI5TDk6hDlLUrBiVvw/o.jpg");
            t.setUrl("https://www.yelp.com/biz/ricos-acai-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(14));
            foodTruckRepo.save(t);
            }

        if (foodTruckRepo.count() == 14) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("american");
            t.setName("Auto Burger And Fry Guys");
            t.setYelpId("auto-burger-and-fry-guys");
            t.setImageURL("https://s3-media3.fl.yelpcdn.com/bphoto/6CXQB-PR7UxU0uX8RN6i0Q/o.jpg");
            t.setUrl("https://www.yelp.com/biz/auto-burger-and-fry-guys-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(15));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 15) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("bao");
            t.setName("A Bao Time");
            t.setYelpId("a-bao-time-charlotte");
            t.setImageURL( "https://s3-media2.fl.yelpcdn.com/bphoto/6m6xKRP7dplVPJOEwml5gA/o.jpg");
            t.setUrl("https://www.yelp.com/biz/a-bao-time-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(16));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 16) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("original");
            t.setName("Twisted Eats");
            t.setYelpId("twisted-eats-charlotte");
            t.setImageURL("https://s3-media4.fl.yelpcdn.com/bphoto/VIkyH8svISIZuFVDhI62gw/o.jpg");
            t.setUrl("https://www.yelp.com/biz/twisted-eats-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(17));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 17) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("taco");
            t.setName("Maki Taco");
            t.setYelpId("maki-taco-charlotte");
            t.setImageURL("https://s3-media2.fl.yelpcdn.com/bphoto/TRa2LgNA5fnZ_NIyrmrzNQ/o.jpg");
            t.setUrl("https://www.yelp.com/biz/maki-taco-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(18));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 18) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("Japanese");
            t.setName("Tiger Yakitori");
            t.setYelpId("tiger-yakitori-charlotte");
            t.setUrl("https://www.yelp.com/biz/tiger-yakitori-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setImageURL("https://s3-media2.fl.yelpcdn.com/bphoto/8kls0_u_K7-vK2Makbdmog/o.jpg");
            t.setLocation(locationRepo.findOne(19));
            foodTruckRepo.save(t);
        }

        if (foodTruckRepo.count() == 19) {

            FoodTruck t = new FoodTruck();
            t.setFoodType("Puerto Rican");
            t.setName("Pinchos El Bori");
            t.setYelpId("pinchos-el-bori-charlotte");
            t.setImageURL("https://s3-media3.fl.yelpcdn.com/bphoto/kCSv3rp4V1HNeyaa9FeFxw/o.jpg");
            t.setUrl("https://www.yelp.com/biz/pinchos-el-bori-charlotte?adjust_creative=kxLUL3GYhNpkDoNv66cpmA&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=kxLUL3GYhNpkDoNv66cpmA");
            t.setLocation(locationRepo.findOne(20));
            foodTruckRepo.save(t);
        }

//

    }

    @PostConstruct
    public void fakeUser() {
        if (userRepo.count() == 0) {

            User u = new User();
            u.setEmail("fakeUser1@foodtruckfinder.com");
            u.setPassword("123");
            u.setUserName("tacoGuy");
            u.setUserType(UserType.owner);
            u.setFoodTruck(foodTruckRepo.findOne(1));
            userRepo.save(u);
        }

        if (userRepo.count() == 1){
            User u = new User();
            u.setEmail("fakeUser2@foodtruckfinder.com");
            u.setPassword("abc");
            u.setUserName("tacoLovin");
            u.setUserType(UserType.customer);
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
        if (locationRepo.count() == 5) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(35.21135);
            l.setLongitude(-80.83387);
            l.setFoodTruck(foodTruckRepo.findOne(6));
            locationRepo.save(l);
        }

        if (locationRepo.count() == 6) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(35.22287);
            l.setLongitude(-80.83796);
            l.setFoodTruck(foodTruckRepo.findOne(7));
            locationRepo.save(l);
        }

        if (locationRepo.count() == 7) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(0.0);
            l.setLongitude(0.0);
            l.setFoodTruck(foodTruckRepo.findOne(8));
            locationRepo.save(l);
        }

        if (locationRepo.count() == 8) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(35.2261484);
            l.setLongitude(-80.8447673);
            l.setFoodTruck(foodTruckRepo.findOne(9));
            locationRepo.save(l);
        }

        if (locationRepo.count() == 9) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(35.21135);
            l.setLongitude(-80.83387);
            l.setFoodTruck(foodTruckRepo.findOne(10));
            locationRepo.save(l);
        }

        if (locationRepo.count() == 10) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(35.2256115700101);
            l.setLongitude(-80.8454956969987);
            l.setFoodTruck(foodTruckRepo.findOne(11));
            locationRepo.save(l);
        }

        if (locationRepo.count() == 11) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(35.2270869);
            l.setLongitude(-80.8431267);
            l.setFoodTruck(foodTruckRepo.findOne(12));
            locationRepo.save(l);
        }

        if (locationRepo.count() == 12) {
            FoodTruckLocation l = new FoodTruckLocation();
            l.setLatitude(35.2326635879196);
            l.setLongitude(-80.8459649607539);
            l.setFoodTruck(foodTruckRepo.findOne(13));
            locationRepo.save(l);
        }





    }

    @PostConstruct
    public void userFavorites() {
        if (favoritesRepo.count() == 0) {
            FoodTruckFavorite f = new FoodTruckFavorite();
            f.setUser(userRepo.findOne(1));
            f.setTruck(foodTruckRepo.findOne(1));
            favoritesRepo.save(f);

        }
    }
    @CrossOrigin
    @GetMapping("/foodtruck/all")
    public Iterable<FoodTruck> getAllFoodTrucks() {
        return foodTruckRepo.findAll();
    }

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

    @CrossOrigin
    @GetMapping("/user")
    public User getUser(HttpSession session) {
        return (User)session.getAttribute(USER_KEY);
    }

    @CrossOrigin
    @PostMapping("/user/foodtruck/add")
    public void addFoodTruckToOwner(@RequestBody FoodTruck foodtruck, HttpSession session, HttpServletResponse response) throws IOException {
        // get the user's ID in the current session
        User u = (User)session.getAttribute(USER_KEY);

        // If the user is an owner, add their food truck information
        if (u.getUserType().equals(UserType.owner)) {
            u.setFoodTruck(foodtruck);
            foodTruckRepo.save(foodtruck);
            userRepo.save(u);

            // If the user is NOT an owner, they will receive an error
        } else {
            response.sendError(422, "User is not a food truck owner and cannot add a food truck.");
        }


//            foodtruck.setUser(u);
//            foodTruckRepo.save(foodtruck);

    }

    // Allows the current "owner" to update the food truck's location. NOTE: This is a "post" method.
    @CrossOrigin
    @PostMapping("/user/start-location")
    public void startLocation(@RequestBody FoodTruckLocation loc, HttpSession session, HttpServletResponse response) throws IOException {
        // Get the user's ID in the current session
        User currentUser = (User)session.getAttribute(USER_KEY);

        if (currentUser != null){
            FoodTruck truck = foodTruckRepo.findOne(currentUser.getFoodTruck().getId());

            if (truck != null){
                // if the truck has a current location, delete it.
                if (truck.getLocation() != null) {
                    locationRepo.delete(truck.getLocation());
                }

                loc.setStartTime(new Date(Instant.now().toEpochMilli()));
                loc.setFoodTruck(truck);
                locationRepo.save(loc);
            } else {
                response.sendError(403, "There is no food truck associated with the current user in session.");
            }
        } else {
            response.sendError(403, "There is no user specified.");
        }

    }

    @CrossOrigin
    @PatchMapping("/user/end-location")
    public void endLocation(HttpSession session, HttpServletResponse response) throws IOException {
        User currentUser = (User)session.getAttribute(USER_KEY);

        if(currentUser != null){
            FoodTruckLocation currentLocation = foodTruckRepo.findOne(currentUser.getFoodTruck().getId()).getLocation();

            currentLocation.setEndTime(new Date(Instant.now().toEpochMilli()));
            locationRepo.save(currentLocation);
        } else{
            response.sendError(403, "No user was specified during this session.");
        }

    }
}
