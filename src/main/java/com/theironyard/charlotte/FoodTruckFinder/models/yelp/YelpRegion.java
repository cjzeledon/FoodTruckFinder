package com.theironyard.charlotte.FoodTruckFinder.models.yelp;

public class YelpRegion {
    private YelpCenter center;

    public YelpCenter getCenter() {
        return center;
    }

    public void setCenter(YelpCenter center) {
        this.center = center;
    }

    @Override
    public String toString() {
        return "YelpRegion{" +
                "center=" + center +
                '}';
    }
}
