package com.theironyard.charlotte.FoodTruckFinder.models.google;

import okhttp3.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleDirection {

    private List<GeocodedWaypoint> geocodedWaypoints = new ArrayList<GeocodedWaypoint>();
    private List<Route> routes = new ArrayList<Route>();
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public GoogleDirection() {
    }

    public GoogleDirection(List<GeocodedWaypoint> geocodedWaypoints, List<Route> routes, String status) {
        super();
        this.geocodedWaypoints = geocodedWaypoints;
        this.routes = routes;
        this.status = status;
    }

    public List<GeocodedWaypoint> getGeocodedWaypoints() {
        return geocodedWaypoints;
    }

    public void setGeocodedWaypoints(List<GeocodedWaypoint> geocodedWaypoints) {
        this.geocodedWaypoints = geocodedWaypoints;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
