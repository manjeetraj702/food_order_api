package in.codingage.FoodOrdering.controller;

import in.codingage.FoodOrdering.model.Restaurant;
import in.codingage.FoodOrdering.model.request.RestaurantCreate;
import in.codingage.FoodOrdering.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @PostMapping
    public Restaurant createRestaurant(@RequestBody RestaurantCreate restaurantCreate)
    {
        return restaurantService.createRestaurant(restaurantCreate);
    }
//    public Restaurant deleteRestaurant(Integer restaurantId,Integer ownerId)
//    {
//
//    }
}
