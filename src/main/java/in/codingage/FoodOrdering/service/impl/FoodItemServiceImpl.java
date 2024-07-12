package in.codingage.FoodOrdering.service.impl;

import in.codingage.FoodOrdering.model.FoodItem;
import in.codingage.FoodOrdering.model.Restaurant;
import in.codingage.FoodOrdering.model.request.fooditem.AddFoodItem;
import in.codingage.FoodOrdering.model.request.fooditem.UpdateFoodItem;
import in.codingage.FoodOrdering.repository.FoodItemRepository;
import in.codingage.FoodOrdering.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    @Autowired
    RestaurantServiceImpl restaurantService;
    @Autowired
    FoodItemRepository foodItemRepository;

    @Override
    public FoodItem addFoodItem(AddFoodItem addFoodItem) {
        FoodItem foodItem = new FoodItem();
        Restaurant restaurant=restaurantService.getRestaurantById(addFoodItem.getRestaurantId());
        if(restaurant !=null && restaurant.getOwnerId().equals(addFoodItem.getOwnerId()))
        {
        foodItem.setName(addFoodItem.getName());
        foodItem.setRestaurant(restaurant);
        foodItem.setPrice(addFoodItem.getPrice());
        foodItem.setDescription(addFoodItem.getDescription());
        restaurant.getFoodItemList().add(foodItem);
        foodItemRepository.save(foodItem);

        }

        return foodItem;
    }

    @Override
    public Optional<FoodItem> updateFoodItem(UpdateFoodItem updateFoodItem) {
        Optional<FoodItem> foodItem = foodItemRepository.findById(updateFoodItem.getId());
        Restaurant restaurant = restaurantService.getRestaurantById(updateFoodItem.getRestaurantId());
        if (restaurant != null && restaurant.getOwnerId().equals(updateFoodItem.getOwnerId()) && foodItem.isPresent()) {
            foodItem.get().setName(updateFoodItem.getName());
            foodItem.get().setRestaurant(restaurant);
            foodItem.get().setPrice(updateFoodItem.getPrice());
            foodItem.get().setDescription(updateFoodItem.getDescription());
            return foodItem;
        }
        return Optional.empty();
    }

    @Override
    public List<FoodItem> getAll() {
        return foodItemRepository.findAll();
    }

    @Override
    public Optional<FoodItem> getFoodItemById(Integer foodItemId) {
        return foodItemRepository.findById(foodItemId);
    }
}
