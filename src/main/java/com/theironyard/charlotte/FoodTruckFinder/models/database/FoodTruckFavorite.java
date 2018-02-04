package com.theironyard.charlotte.FoodTruckFinder.models.database;

import javax.persistence.*;

@Entity
@Table (name = "favorites")
public class FoodTruckFavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private FoodTruck truck;

    @OneToOne
    private User user;

    public FoodTruckFavorite() {
    }
    public FoodTruckFavorite(int id, FoodTruck truck, User user) {
        this.id = id;
        this.truck = truck;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FoodTruck getTruck() {
        return truck;
    }

    public void setTruck(FoodTruck truck) {
        this.truck = truck;
    }

    @Override
    public String toString() {
        return "FoodTruckFavorite{" +
                "id=" + id +
                ", truck=" + truck +
                '}';
    }
}
