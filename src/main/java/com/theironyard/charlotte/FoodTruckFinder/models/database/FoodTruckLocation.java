package com.theironyard.charlotte.FoodTruckFinder.models.database;

import javax.persistence.*;
import java.sql.Date;

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
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}