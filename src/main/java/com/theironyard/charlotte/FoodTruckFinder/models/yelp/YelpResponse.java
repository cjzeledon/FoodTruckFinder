package com.theironyard.charlotte.FoodTruckFinder.models.yelp;

import com.theironyard.charlotte.FoodTruckFinder.models.yelp.YelpBusiness;
import com.theironyard.charlotte.FoodTruckFinder.models.yelp.YelpRegion;

import java.util.List;

public class YelpResponse {
    private List<YelpBusiness> businesses;
    private int total;
    private YelpRegion region;

    public List<YelpBusiness> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<YelpBusiness> businesses) {
        this.businesses = businesses;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public YelpRegion getRegion() {
        return region;
    }

    public void setRegion(YelpRegion region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "YelpResponse{" +
                "businesses=" + businesses +
                ", total=" + total +
                ", region=" + region +
                '}';
    }
}
