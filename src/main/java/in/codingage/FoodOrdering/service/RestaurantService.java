package in.codingage.FoodOrdering.service;

import in.codingage.FoodOrdering.model.Restaurant;
import in.codingage.FoodOrdering.model.request.restaurant.RestaurantCreate;
import in.codingage.FoodOrdering.model.request.restaurant.RestaurantUpdate;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    Restaurant createRestaurant(RestaurantCreate restaurantCreate);

    Optional<Restaurant> updateRestaurant(RestaurantUpdate restaurantUpdate);

    boolean deleteRestaurant(Integer ownerId, Integer restaurantId);

    Restaurant getRestaurantById(Integer restaurantId);

    List<Restaurant> getRestaurantsByOwnerId(Integer ownerId, String password);

    List<Restaurant> getAllRestaurant();
}

