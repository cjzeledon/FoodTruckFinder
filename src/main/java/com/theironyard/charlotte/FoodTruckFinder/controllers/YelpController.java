package com.theironyard.charlotte.FoodTruckFinder.controllers;

import com.theironyard.charlotte.FoodTruckFinder.models.yelp.YelpBusiness;
import com.theironyard.charlotte.FoodTruckFinder.models.yelp.YelpResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class YelpController {

    private static final String TOKEN = System.getenv("YELP_ACCESS_KEY");

    @CrossOrigin
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

    @CrossOrigin
    @GetMapping("/foodtrucks/{id}")
    public YelpBusiness oneFoodTruck(@PathVariable String id){
        RestTemplate yelpTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        YelpBusiness response = yelpTemplate
                .exchange("https://api.yelp.com/v3/businesses/" + id,
                        HttpMethod.GET,
                        entity,
                        YelpBusiness.class)
                .getBody();

        return response;
    }
}
