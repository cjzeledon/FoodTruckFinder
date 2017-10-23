package com.theironyard.charlotte.FoodTruckFinder.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theironyard.charlotte.FoodTruckFinder.models.yelp.YelpBusiness;
import com.theironyard.charlotte.FoodTruckFinder.models.yelp.YelpCoordinates;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.MalformedURLException;
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

//        YelpBusiness response = yelpTemplate
//                .exchange("https://api.yelp.com/v3/businesses/" + id,
//                        HttpMethod.GET,
//                        entity,
//                        YelpBusiness.class)
//                .getBody();

        YelpCoordinates yResponse = yelpTemplate
                .exchange("https://api.yelp.com/v3/businesses/" + id,
                        HttpMethod.GET,
                        entity,
                        YelpBusiness.class)
                .getBody().getCoordinates();

        return yResponse;
        }

// https://maps.googleapis.com/maps/api/directions/json?origin=35.2273,-80.8466&destination=35.1053,-80.646018&mode=walking&key=AIzaSyBRFlkrdZfBZpzGVglvLJG2LXnG4rgjaK0

//    @CrossOrigin
//    @GetMapping("/directions/{truck_id}")
    // business ID : frontend
    // origin lat: frontend
    // origin long: frontend
    // destination lat: backend
    // destination long: backend
//    public JsonNode walkingDirection (@RequestParam float lat, @RequestParam float lng,
//                                      @PathVariable String truck_id) throws IOException {
//
////        Double latitude = oneFoodTruck(truck_id).getLatitude();
////        Double longitude = oneFoodTruck(truck_id).getLongitude();
////
////        truck_id = "35.2127456665039,-80.7965927124023";
//
//        RestTemplate googleTemplate = new RestTemplate();
////        String response = "https://maps.googleapis.com/maps/api/directions/json?origin=" + lat + lng + "&destination=" + truck_id + "&mode=" + travelMode + "&key=" + GTOKEN;
//
//        // ******************* FIRST TRY
////        GoogleDirection response =
////                googleTemplate.exchange("https://maps.googleapis.com/maps/api/directions/json?origin=" + lat + lng + "&destination=" + truck_id + "&mode=" + travelMode + "&key=" + GTOKEN,
////                        HttpMethod.GET,
////                        GoogleDirection.class)
////                .getBody();
////        return response;
//
//        // ******************* SECOND TRY
////        GoogleDirection gResponse = googleTemplate
////                .getForObject("https://maps.googleapis.com/maps/api/directions/json?origin=" + lat + lng + "&destination=" + truck_id + "&mode=" + travelMode + "&key=" + GTOKEN,
////                        GoogleDirection.class);
////        return gResponse;
//
//        // ******************* THIRD TRY
//        ObjectMapper mapper = new ObjectMapper();
//
//        URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + lat + lng + "&destination=" + truck_id + "&mode=" + travelMode + "&key=" + GTOKEN);
//        JsonNode gDirection = mapper.readValue(url, JsonNode.class);
//        return gDirection;
//
//        // ******************* FOURTH TRY
//
//
//
//
//    }

    @CrossOrigin
    @GetMapping("/directions/{origin}/{destination}")
    public JsonNode walkingDirection (@PathVariable String origin, @PathVariable String destination) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + origin + "&destination=" + destination + "&mode=" + travelMode + "&key=" + GTOKEN);
        JsonNode gDirection = mapper.readValue(url, JsonNode.class);
        return gDirection;

        // ******************* FOURTH TRY




    }
}
