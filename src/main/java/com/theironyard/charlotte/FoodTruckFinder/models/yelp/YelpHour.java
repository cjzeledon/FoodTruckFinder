package com.theironyard.charlotte.FoodTruckFinder.models.yelp;

import java.util.List;

public class YelpHour {
    private boolean is_open_now;
    private String hours_type;
    private List<YelpOpenHour> open;

    public boolean isIs_open_now() {
        return is_open_now;
    }

    public void setIs_open_now(boolean is_open_now) {
        this.is_open_now = is_open_now;
    }

    public String getHours_type() {
        return hours_type;
    }

    public void setHours_type(String hours_type) {
        this.hours_type = hours_type;
    }

    public List<YelpOpenHour> getOpen() {
        return open;
    }

    public void setOpen(List<YelpOpenHour> open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "YelpHour{" +
                "is_open_now=" + is_open_now +
                ", hours_type='" + hours_type + '\'' +
                ", open=" + open +
                '}';
    }
}