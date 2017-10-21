package com.theironyard.charlotte.FoodTruckFinder.models.database;

import javax.persistence.*;


@Entity
@Table(name="food_truck")
public class FoodTruck{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false, updatable = true)
    private String name;

    @Column (nullable = false, updatable = true)
    private String foodType;

    @Column (nullable = true, updatable = false)
    private String yelpId;

    @Column (nullable = true, updatable = false)
    private String imageURL;

    @Column (nullable = true, updatable = false)
    private String url;

    @OneToOne
    private FoodTruckLocation location;


    public FoodTruck() {
    }

    public FoodTruck(int id, String name, String foodType, String yelpId, String imageURL, String url) {
        this.id = id;
        this.name = name;
        this.foodType = foodType;
        this.yelpId = yelpId;
        this.imageURL = imageURL;
        this.url = url;
    }

    public FoodTruckLocation getLocation() { return location; }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getYelpId() {
        return yelpId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setYelpId(String yelpId) {
        this.yelpId = yelpId;

    }
}
