package com.theironyard.charlotte.FoodTruckFinder.repositories;


import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruckFavorite;
import com.theironyard.charlotte.FoodTruckFinder.models.database.FoodTruckFavorite;
import org.springframework.data.repository.CrudRepository;


public interface FavoritesRepository
        extends CrudRepository<FoodTruckFavorite, Integer> {
}
