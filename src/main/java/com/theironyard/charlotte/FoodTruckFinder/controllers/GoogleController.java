package com.theironyard.charlotte.FoodTruckFinder.controllers;

import com.theironyard.charlotte.FoodTruckFinder.models.yelp.YelpBusiness;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class GoogleController {
    private static final String GTOKEN = System.getenv("GOOGLE_API_KEY");
    private static final String YTOKEN = System.getenv("YELP_ACCESS_KEY");
    private String travelMode = "walking"; // choose either driving, walking, bicycling, or transit

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

// https://maps.googleapis.com/maps/api/directions/json?origin=35.2273,-80.8466&destination=35.1053,-80.646018&mode=walking&key=AIzaSyBRFlkrdZfBZpzGVglvLJG2LXnG4rgjaK0

    @CrossOrigin
    @GetMapping("/directions/{id}")
    // business ID : frontend
    // origin lat: frontend
    // origin long: frontend
    // destination lat: backend
    // destination long: backend
    public String walkingDirection (@RequestParam float lat, @RequestParam float lng){
        RestTemplate googleTemplate = new RestTemplate();
        String response = "https://maps.googleapis.com/maps/api/directions/json?origin=" + lat + lng + "&destination=Montreal&mode=" + travelMode + "&key=" + GTOKEN;

        return response;
    }

}
