package com.theironyard.charlotte.FoodTruckFinder.models.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;

@Entity
@Table (name = "truck_location")
public class FoodTruckLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = true, updatable = true)
    private String address;

    @Column(nullable = true, updatable = true)
    private double latitude;

    @Column(nullable = true, updatable = true)
    private double longitude;

    @Column(nullable = true, updatable = true)
    private Date startTime;

    @Column(nullable = true, updatable = true)
    private Date endTime;

    @OneToOne
    @JsonIgnore //will not include the food truck property in json to avoid creating an infinite loop
    private FoodTruck foodTruck;

    public FoodTruckLocation() {
    }

    public FoodTruckLocation(int id, double latitude, double longitude, Date startTime, Date endTime, String address) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.DOWN);
        return Double.valueOf(df.format(latitude));
//        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.DOWN);
        return Double.valueOf(df.format(longitude));
//        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public FoodTruck getFoodTruck() {
        return foodTruck;
    }

    public void setFoodTruck(FoodTruck foodTruck) {
        this.foodTruck = foodTruck;
    }

    @Override
    public String toString() {
        return "FoodTruckLocation{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", foodTruck=" + foodTruck +
                '}';
    }
}