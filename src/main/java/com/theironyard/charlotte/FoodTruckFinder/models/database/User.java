package com.theironyard.charlotte.FoodTruckFinder.models.database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private UserType userType;

    public User() {
    }

    @OneToOne
    @JsonIgnore //will not include the food truck property in json to avoid creating an infinite loop
    private FoodTruck foodTruck;

    public User(int id, String userName, String email, String password, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public User(int id, String userName, String email, String password, UserType userType, FoodTruck foodTruck) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.foodTruck = foodTruck;
    }

    public FoodTruck getFoodTruck() {
        return foodTruck;
    }

    public void setFoodTruck(FoodTruck foodTruck) {
        this.foodTruck = foodTruck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (getUserName() != null ? !getUserName().equals(user.getUserName()) : user.getUserName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getUserType() != user.getUserType()) return false;
        return getFoodTruck() != null ? getFoodTruck().equals(user.getFoodTruck()) : user.getFoodTruck() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getUserType() != null ? getUserType().hashCode() : 0);
        result = 31 * result + (getFoodTruck() != null ? getFoodTruck().hashCode() : 0);
        return result;
    }
}