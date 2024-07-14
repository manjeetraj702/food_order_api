package in.codingage.FoodOrdering.service.impl;

import in.codingage.FoodOrdering.Validator;
import in.codingage.FoodOrdering.model.Restaurant;
import in.codingage.FoodOrdering.model.User;
import in.codingage.FoodOrdering.model.request.restaurant.RestaurantCreate;
import in.codingage.FoodOrdering.model.request.restaurant.RestaurantUpdate;
import in.codingage.FoodOrdering.repository.RestaurantRepository;
import in.codingage.FoodOrdering.service.RestaurantService;
import in.codingage.FoodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(RestaurantCreate restaurantCreate) {
        if(!Validator.isValidPhoneNumber(restaurantCreate.getPhone()))
        {
            return new Restaurant();
        }
        Optional<User> user=userService.getById(restaurantCreate.getOwnerId());
        if(user.isPresent() && user.get().getRole().equalsIgnoreCase("owner")) {
            if ((restaurantRepository.findByPhone(restaurantCreate.getPhone())) == null) {
                Restaurant restaurant = new Restaurant();
                restaurant.setName(restaurantCreate.getName());
                restaurant.setAddress(restaurantCreate.getAddress());
                restaurant.setOwnerId(restaurantCreate.getOwnerId());
                restaurant.setPhone(restaurantCreate.getPhone());
                return restaurantRepository.save(restaurant);
            }
        }
        return new Restaurant();
    }

    @Override
    public Optional<Restaurant> updateRestaurant(RestaurantUpdate restaurantUpdate) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantUpdate.getRestaurantId());
        if (restaurant.isPresent() && restaurant.get().getOwnerId().equals(restaurantUpdate.getOwnerId())) {
            restaurant.get().setPhone(restaurantUpdate.getPhone());
            restaurant.get().setName(restaurantUpdate.getName());
            restaurant.get().setAddress(restaurantUpdate.getAddress());
            return restaurant;
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteRestaurant(Integer ownerId, Integer restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isPresent() && restaurant.get().getOwnerId().equals(ownerId)) {
            restaurantRepository.deleteById(restaurantId);
            return true;
        }
        return false;
    }

    @Override
    public Restaurant getRestaurantById(Integer restaurantId) {

        return restaurantRepository.getReferenceById(restaurantId);
    }

    @Override
    public List<Restaurant> getRestaurantsByOwnerId(Integer ownerId, String password) {
        Optional<User> user = userService.getById(ownerId);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return restaurantRepository.findRestaurantByOwnerId(ownerId);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }
}
