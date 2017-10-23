package com.theironyard.charlotte.FoodTruckFinder.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theironyard.charlotte.FoodTruckFinder.models.google.GoogleDirection;
import com.theironyard.charlotte.FoodTruckFinder.models.yelp.YelpBusiness;
import com.theironyard.charlotte.FoodTruckFinder.models.yelp.YelpCoordinates;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;

@RestController
public class GoogleController {
    private static final String GTOKEN = System.getenv("GOOGLE_API_KEY");
    private static final String YTOKEN = System.getenv("YELP_ACCESS_KEY");
    private String travelMode = "walking"; // choose either driving, walking, bicycling, or transit

    public YelpCoordinates oneFoodTruck(String id){
        RestTemplate yelpTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + YTOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        YelpCoordinates yResponse = yelpTemplate
                .exchange("https://api.yelp.com/v3/businesses/" + id,
                        HttpMethod.GET,
                        entity,
                        YelpBusiness.class)
                .getBody().getCoordinates();

        return yResponse;
        }

    @CrossOrigin
    @GetMapping("/directions/{truck_id}")
    public JsonNode walkingDirection (@PathVariable String truck_id, @RequestParam String origin) throws IOException {

        YelpCoordinates coords = oneFoodTruck(truck_id);

        RestTemplate googleTemplate = new RestTemplate();

        ObjectMapper mapper = new ObjectMapper();

        URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + origin + "&destination=" + coords.getLatitude() + "," + coords.getLongitude() + "&mode=" + travelMode + "&key=" + GTOKEN);
        JsonNode gDirection = mapper.readValue(url, JsonNode.class);
        return gDirection;

    }

/*
// This is another option that also works to get the direction
@CrossOrigin
// /directions/-35.232,81.03423/-35.44,81.200
// /directions?origin=-35.232,81.03423&destination=-35.44,81.200
@GetMapping("/directions")
public JsonNode walkingDirection (@RequestParam String origin, @RequestParam String destination) throws IOException {

ObjectMapper mapper = new ObjectMapper();

URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + origin + "&destination=" + destination + "&mode=" + travelMode + "&key=" + GTOKEN);
JsonNode gDirection = mapper.readValue(url, JsonNode.class);
return gDirection;
}
*/
}
