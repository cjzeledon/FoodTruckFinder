package com.theironyard.charlotte.FoodTruckFinder.models;

import javax.persistence.*;

@Entity
@Table(name = "favorite")
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
