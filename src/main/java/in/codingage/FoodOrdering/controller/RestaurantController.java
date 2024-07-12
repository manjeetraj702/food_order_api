package in.codingage.FoodOrdering.controller;

import in.codingage.FoodOrdering.model.Restaurant;
import in.codingage.FoodOrdering.model.request.restaurant.RestaurantCreate;
import in.codingage.FoodOrdering.model.request.restaurant.RestaurantUpdate;
import in.codingage.FoodOrdering.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/createRestaurant")
    public Restaurant createRestaurant(@RequestBody RestaurantCreate restaurantCreate) {
        return restaurantService.createRestaurant(restaurantCreate);
    }

    @DeleteMapping("/deleteRestaurant")
    public boolean deleteRestaurant(@RequestParam Integer ownerId, Integer restaurantId) {
        return restaurantService.deleteRestaurant(ownerId, restaurantId);
    }

    @GetMapping("/getRestaurantsByOwnerId")
    public List<Restaurant> getRestaurantsByOwnerId(@RequestParam Integer ownerId, String password) {
        return restaurantService.getRestaurantsByOwnerId(ownerId, password);
    }

    @GetMapping("/getAllRestaurant")
    public List<Restaurant> getAllRestaurant() {
        return restaurantService.getAllRestaurant();
    }

    @PutMapping("/updateRestaurant")
    public Optional<Restaurant> updateRestaurant(@RequestBody RestaurantUpdate restaurantUpdate) {
        return restaurantService.updateRestaurant(restaurantUpdate);
    }

}
