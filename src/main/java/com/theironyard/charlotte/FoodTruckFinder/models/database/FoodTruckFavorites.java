package com.theironyard.charlotte.FoodTruckFinder.models.database;

import javax.persistence.*;

@Entity
@Table (name = "favorites")
public class FoodTruckFavorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private int user_id;

    @Column (nullable = false)
    private int foodTruck_id;

    @Column (nullable = false)
    private String food_type;

    public FoodTruckFavorites(int id, int user_id, int foodTruck_id, String food_type) {
        this.id = id;
        this.user_id = user_id;
        this.foodTruck_id = foodTruck_id;
        this.food_type = food_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFoodTruck_id() {
        return foodTruck_id;
    }

    public void setFoodTruck_id(int foodTruck_id) {
        this.foodTruck_id = foodTruck_id;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }
}
