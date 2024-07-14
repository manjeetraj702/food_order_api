package in.codingage.FoodOrdering.controller;

import in.codingage.FoodOrdering.model.FoodItem;
import in.codingage.FoodOrdering.model.request.fooditem.AddFoodItem;
import in.codingage.FoodOrdering.model.request.fooditem.UpdateFoodItem;
import in.codingage.FoodOrdering.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/food")
public class FoodController {
    @Autowired
    FoodItemService foodItemService;

    @PostMapping("/addFoodItem")
    public FoodItem addFoodItem(@RequestBody AddFoodItem addFoodItem) {
        return foodItemService.addFoodItem(addFoodItem);
    }

    @PutMapping("/updateFoodItem")
    public Optional<FoodItem> updateFoodItem(@RequestBody UpdateFoodItem updateFoodItem) {
        return foodItemService.updateFoodItem(updateFoodItem);
    }
    @GetMapping("/getAllFoodItem")
    public List<FoodItem> getAllFoodItem()
    {
        return foodItemService.getAllFoodItem();
    }
    @GetMapping("/getFoodItemById")
    public Optional<FoodItem> getFoodItemById(@RequestParam Integer foodItem)
    {
        return foodItemService.getFoodItemById(foodItem);
    }
    @GetMapping("/getFoodItemByRestaurantId")
    public List<FoodItem> getFoodItemByRestaurantId(@RequestParam Integer restaurantId)
    {
        return foodItemService.getFoodItemByRestaurantId(restaurantId);
    }

}
