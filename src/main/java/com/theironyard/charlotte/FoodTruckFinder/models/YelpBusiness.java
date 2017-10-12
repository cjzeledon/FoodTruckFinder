package com.theironyard.charlotte.FoodTruckFinder.models;

import org.json.JSONObject;

import java.util.List;

public class YelpBusiness {
    private String id;
    private String name;
    private String image_url;
    private String url;
    private double rating;
    private int review_count;
    private String phone;
//    private List<YelpHour> hours;
    private YelpCoordinates coordinates;
    private YelpLocation location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public YelpCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(YelpCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public YelpLocation getLocation() {
        return location;
    }

    public void setLocation(YelpLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "YelpBusiness{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", url='" + url + '\'' +
                ", rating=" + rating +
                ", review_count=" + review_count +
                ", phone='" + phone + '\'' +
                ", coordinates=" + coordinates +
                ", location=" + location +
                '}';
    }
}
