package com.theironyard.charlotte.FoodTruckFinder.models.database;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;


@Entity
@Table(name="food_truck")
public class FoodTruck{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = true, updatable = true)
    private String name;

    @Column (nullable = true, updatable = true)
    private String foodType;

    @Column (nullable = true, updatable = false)
    private String yelpId;

    @Column (nullable = true, updatable = false)
    private String imageURL;

    @Column (nullable = true, updatable = false)
    private String url;

    @OneToOne(mappedBy = "foodTruck")
    private FoodTruckLocation location;

    @OneToOne(mappedBy = "foodTruck")
//    @Cascade(org.hibernate.annotations.CascadeType.ALL) // This means when FoodTruck is saved, save the user as well.
    private User user;


    public FoodTruck() {
    }

<<<<<<< HEAD
=======

>>>>>>> 566b4965e2f32722e4510014ce5aa88e0fbcb8df
    public FoodTruck(int id, String name, String foodType, String yelpId, String imageURL, String url, FoodTruckLocation location, User user) {
        this.id = id;
        this.name = name;
        this.foodType = foodType;
        this.yelpId = yelpId;
        this.imageURL = imageURL;
        this.url = url;
        this.location = location;
        this.user = user;
    }

    public FoodTruckLocation getLocation() { return location; }

    public User getUser() {return user; }

    public void setUser(User user) {
        this.user = user;
    }

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

    public void setLocation(FoodTruckLocation location) {
        this.location = location;
    }
}
