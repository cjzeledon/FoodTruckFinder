package com.theironyard.charlotte.FoodTruckFinder.repositories;

import com.theironyard.charlotte.FoodTruckFinder.models.database.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
    User findFirstByUserNameAndPassword(String userName, String password);

    User findFirstByUserName(String userName);
}
