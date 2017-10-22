package com.theironyard.charlotte.FoodTruckFinder.models.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Route {

    private Bounds bounds;
    private String copyrights;
    private List<Leg> legs = new ArrayList<Leg>();
    private OverviewPolyline overviewPolyline;
    private String summary;
    private List<String> warnings = new ArrayList<String>();
    private List<Object> waypointOrder = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Route() {
    }

    public Route(Bounds bounds, String copyrights, List<Leg> legs, OverviewPolyline overviewPolyline, String summary, List<String> warnings, List<Object> waypointOrder) {
        super();
        this.bounds = bounds;
        this.copyrights = copyrights;
        this.legs = legs;
        this.overviewPolyline = overviewPolyline;
        this.summary = summary;
        this.warnings = warnings;
        this.waypointOrder = waypointOrder;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public OverviewPolyline getOverviewPolyline() {
        return overviewPolyline;
    }

    public void setOverviewPolyline(OverviewPolyline overviewPolyline) {
        this.overviewPolyline = overviewPolyline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public List<Object> getWaypointOrder() {
        return waypointOrder;
    }

    public void setWaypointOrder(List<Object> waypointOrder) {
        this.waypointOrder = waypointOrder;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
