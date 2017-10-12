package com.theironyard.charlotte.FoodTruckFinder.controllers;

import com.theironyard.charlotte.FoodTruckFinder.models.YelpResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class YelpController {
//    private static final String API_HOST = "api.yelp.com";
//    private static final String DEFAULT_TERM = "Food Trucks";
//    private static final String DEFAULT_LOCATION = "Charlotte, NC";
//    private static final int SEARCH_LIMIT = 5;
//    private static final String SEARCH_PATH = "/v3/search/";
//    private static final String BUSINESS_PATH = "/v3/businesses/";
    private static final String TOKEN = System.getenv("YELP_ACCESS_KEY");

    @GetMapping("/foodtrucks")
    public YelpResponse foodTrucks (){
        RestTemplate yelpTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        YelpResponse response = yelpTemplate
                .exchange("https://api.yelp.com/v3/businesses/search?term=food+truck&latitude=35.227085&longitude=-80.843124",
                    HttpMethod.GET,
                    entity,
                    YelpResponse.class)
                .getBody();

        return response;
    }

}
