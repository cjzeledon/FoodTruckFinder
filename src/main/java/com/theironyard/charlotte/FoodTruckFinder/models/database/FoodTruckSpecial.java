package com.theironyard.charlotte.FoodTruckFinder.models.database;

import javax.persistence.*;

@Entity
@Table(name = "special")
public class FoodTruckSpecial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "foodtruck_id", nullable = false)
    private FoodTruck truck;


    public FoodTruckSpecial() {
    }

    public FoodTruckSpecial(int id, String name, String description, FoodTruck truck) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.truck = truck;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodTruck getTruck() {
        return truck;
    }

    public void setTruck(FoodTruck truck) {
        this.truck = truck;
    }
}
