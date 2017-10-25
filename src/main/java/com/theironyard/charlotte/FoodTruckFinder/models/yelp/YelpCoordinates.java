package com.theironyard.charlotte.FoodTruckFinder.models.yelp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class YelpCoordinates {
    private double latitude;
    private double longitude;

    public double getLatitude() {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.DOWN);
        return Double.valueOf(df.format(latitude));
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.DOWN);
        return Double.valueOf(df.format(longitude));
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
