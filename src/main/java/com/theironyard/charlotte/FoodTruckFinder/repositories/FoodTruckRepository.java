package com.theironyard.charlotte.FoodTruckFinder.repositories;

import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruck;
import org.springframework.data.repository.CrudRepository;

public interface FoodTruckRepository extends CrudRepository<FoodTruck, Integer>{

    FoodTruck findFirstByName(String name);

    FoodTruck findFirstByYelpId(String yelpId);
}
