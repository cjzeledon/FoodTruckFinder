package com.theironyard.charlotte.FoodTruckFinder.models;

import javax.persistence.*;

@Entity
@Table(name = "food_truck_owner")
public class FoodTruckOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private String ownerName;

    @Column (nullable = false)
    private String companyName;
}
