package com.theironyard.charlotte.FoodTruckFinder.repositories;

import com.theironyard.charlotte.FoodTruckFinder.models.database.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
    User findFirstByNameAndPassword(String userName, String password);

    User findFirstByName(String userName);
}
