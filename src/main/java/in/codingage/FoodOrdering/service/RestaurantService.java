package in.codingage.FoodOrdering.service;

import in.codingage.FoodOrdering.model.Restaurant;
import in.codingage.FoodOrdering.model.request.RestaurantCreate;
import in.codingage.FoodOrdering.model.request.RestaurantUpdate;

import java.util.List;

public interface RestaurantService {
    Restaurant createRestaurant(RestaurantCreate restaurantCreate);
    Restaurant updateRestaurant(RestaurantUpdate restaurantUpdate);
    boolean deleteRestaurant(Integer ownerId,Integer restaurantId);
    List<Restaurant> getRestaurantsByOwnerId(Integer ownerId,String password);
}

