package com.theironyard.charlotte.FoodTruckFinder.repositories;


import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruckFavorites;
import org.springframework.data.repository.CrudRepository;


public interface FavoritesRepository
        extends CrudRepository<FoodTruckFavorites, Integer> {
}
