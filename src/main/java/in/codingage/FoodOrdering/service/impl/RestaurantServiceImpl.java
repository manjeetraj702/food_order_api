package in.codingage.FoodOrdering.service.impl;

import in.codingage.FoodOrdering.model.Restaurant;
import in.codingage.FoodOrdering.model.User;
import in.codingage.FoodOrdering.model.request.RestaurantCreate;
import in.codingage.FoodOrdering.model.request.RestaurantUpdate;
import in.codingage.FoodOrdering.repository.RestaurantRepository;
import in.codingage.FoodOrdering.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(RestaurantCreate restaurantCreate) {
        if((restaurantRepository.findByPhone(restaurantCreate.getPhone()))==null) {
            Restaurant restaurant = new Restaurant();
            restaurant.setName(restaurantCreate.getName());
            restaurant.setAddress(restaurantCreate.getAddress());
            restaurant.setOwnerId(restaurantCreate.getOwnerId());
            restaurant.setPhone(restaurantCreate.getPhone());
            return restaurantRepository.save(restaurant);
        }
        return new Restaurant();
    }

    @Override
    public Restaurant updateRestaurant(RestaurantUpdate restaurantUpdate) {
      Optional<Restaurant> restaurant =  restaurantRepository.findById(restaurantUpdate.getRestaurantId());
      if(restaurant.isPresent() && restaurant.get().getOwnerId().equals(restaurantUpdate.getOwnerId()) )
      {
          restaurant.get().setPhone(restaurantUpdate.getPhone());
          restaurant.get().setName(restaurantUpdate.getName());
          restaurant.get().setAddress(restaurantUpdate.getAddress());
      }
        return null;
    }

    @Override
    public boolean deleteRestaurant(Integer ownerId, Integer restaurantId) {
        Optional<Restaurant> restaurant=restaurantRepository.findById(restaurantId);
        if(restaurant.isPresent() && restaurant.get().getOwnerId().equals(ownerId))
        {
            restaurantRepository.deleteById(restaurantId);
        }
        return false;
    }

    @Override
    public List<Restaurant> getRestaurantsByOwnerId(Integer ownerId, String password) {
       Optional <User> user=userService.getUserById(ownerId);
       if(user.isPresent() && user.get().getPassword().equals(password))
       {
           return restaurantRepository.getRestaurantByOwnerId(ownerId);
       }
        return new ArrayList<>();
    }
}
