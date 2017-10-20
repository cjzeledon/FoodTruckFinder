package com.theironyard.charlotte.FoodTruckFinder.repositories;


import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruckLocation;
import org.springframework.data.repository.CrudRepository;

public interface FoodTruckLocationRepository
        extends CrudRepository<FoodTruckLocation, Integer> {
}
