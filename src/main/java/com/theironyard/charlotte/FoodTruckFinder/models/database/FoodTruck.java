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

    @OneToOne
    private FoodTruckLocation location;


    public FoodTruck(int id, String name, String foodType, String yelpId) {
        this.id = id;
        this.name = name;
        this.foodType = foodType;
        this.yelpId = yelpId;
    }

    public FoodTruckLocation getLocation() { return location; }
    //this may not work. What is wrong here?

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

    public void setYelpId(String yelpId) {
        this.yelpId = yelpId;
    }
}
