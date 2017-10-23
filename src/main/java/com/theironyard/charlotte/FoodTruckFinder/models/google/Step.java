package com.theironyard.charlotte.FoodTruckFinder.models.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Step {

    private Distance_ distance;
    private Duration_ duration;
    private EndLocation_ endLocation;
    private String htmlInstructions;
    private Polyline polyline;
    private StartLocation_ startLocation;
    private String travelMode;
    private String maneuver;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Step() {
    }

    public Step(Distance_ distance, Duration_ duration, EndLocation_ endLocation, String htmlInstructions, Polyline polyline, StartLocation_ startLocation, String travelMode, String maneuver) {
        super();
        this.distance = distance;
        this.duration = duration;
        this.endLocation = endLocation;
        this.htmlInstructions = htmlInstructions;
        this.polyline = polyline;
        this.startLocation = startLocation;
        this.travelMode = travelMode;
        this.maneuver = maneuver;
    }

    public Distance_ getDistance() {
        return distance;
    }

    public void setDistance(Distance_ distance) {
        this.distance = distance;
    }

    public Duration_ getDuration() {
        return duration;
    }

    public void setDuration(Duration_ duration) {
        this.duration = duration;
    }

    public EndLocation_ getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(EndLocation_ endLocation) {
        this.endLocation = endLocation;
    }

    public String getHtmlInstructions() {
        return htmlInstructions;
    }

    public void setHtmlInstructions(String htmlInstructions) {
        this.htmlInstructions = htmlInstructions;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public void setPolyline(Polyline polyline) {
        this.polyline = polyline;
    }

    public StartLocation_ getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(StartLocation_ startLocation) {
        this.startLocation = startLocation;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    public String getManeuver() {
        return maneuver;
    }

    public void setManeuver(String maneuver) {
        this.maneuver = maneuver;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

