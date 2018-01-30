package com.theironyard.charlotte.FoodTruckFinder.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruck;
import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruckLocation;
import com.theironyard.charlotte.FoodTruckFinder.models.yelp.YelpBusiness;
import com.theironyard.charlotte.FoodTruckFinder.models.yelp.YelpResponse;
import com.theironyard.charlotte.FoodTruckFinder.repositories.FoodTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class YelpController {

    private static final String YTOKEN = System.getenv("YELP_ACCESS_KEY");

    @Autowired
    FoodTruckRepository foodTruckRepo;

//    @Autowired
//    User userRepo;

    @CrossOrigin
    @GetMapping("/foodtrucks")
    public List<FoodTruck> foodTrucks (){
        RestTemplate yelpTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + YTOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        YelpResponse response = yelpTemplate
                .exchange("https://api.yelp.com/v3/businesses/search?term=food+truck&latitude=35.227085&longitude=-80.843124",
                    HttpMethod.GET,
                    entity,
                    YelpResponse.class)
                .getBody();

        List<FoodTruck> trucks = new ArrayList<FoodTruck>();
//        List<YelpBusiness> yTruck = new ArrayList<YelpBusiness>();

        for (YelpBusiness business : response.getBusinesses()) {
            // Create FoodTruck object for each business
            // int id, String name, String foodType, String yelpId, String imageURL, String url, FoodTruckLocation location, User user
            FoodTruck newTruck = new FoodTruck();
            YelpBusiness yBusiness = new YelpBusiness();
//            newTruck.setId(newTruck.getId());
            newTruck.setName(business.getName());
//            newTruck.setFoodType(business.foodType);
            newTruck.setImageURL(business.getImage_url());
            newTruck.setUrl(business.getUrl());
            yBusiness.setRating(business.getRating());
            newTruck.setYelpId(business.getId());

            FoodTruckLocation location = new FoodTruckLocation();
            FoodTruck dbTruck = foodTruckRepo.findFirstByYelpId(newTruck.getYelpId());

            if (dbTruck != null) {
                if (dbTruck.getLocation() != null) {
                    newTruck.setLocation(dbTruck.getLocation());
                } else {
                    location.setLatitude(business.getCoordinates().getLatitude());
                    location.setLongitude(business.getCoordinates().getLongitude());
//                    dbTruck.setId(newTruck.getId());
                    newTruck.setId(dbTruck.getId());
                    newTruck.setLocation(location);

                }
            }

            trucks.add(newTruck);
//            yTruck.add(yBusiness);


        }

        return trucks;
    }

    @CrossOrigin
    @GetMapping("/foodtrucks/{id}")
    public YelpBusiness oneFoodTruck(@PathVariable String id){
        RestTemplate yelpTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + YTOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        YelpBusiness response = yelpTemplate
                .exchange("https://api.yelp.com/v3/businesses/" + id,
                        HttpMethod.GET,
                        entity,
                        YelpBusiness.class)
                .getBody();

        return response;
    }

    @CrossOrigin
    @GetMapping("/foodtrucks/reviews")
    public JsonNode yelpReviews(@RequestParam String id) throws IOException {
        RestTemplate yelpTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + YTOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        JsonNode response = yelpTemplate
                .exchange("https://api.yelp.com/v3/businesses/" + id + "/reviews",
                        HttpMethod.GET,
                        entity,
                        JsonNode.class)
                .getBody();
        return response;
    }
}
