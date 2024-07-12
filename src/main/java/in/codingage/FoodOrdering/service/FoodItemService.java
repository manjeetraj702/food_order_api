package in.codingage.FoodOrdering.service;

import in.codingage.FoodOrdering.model.FoodItem;
import in.codingage.FoodOrdering.model.request.fooditem.AddFoodItem;
import in.codingage.FoodOrdering.model.request.fooditem.UpdateFoodItem;

import java.util.List;
import java.util.Optional;

public interface FoodItemService {
    FoodItem addFoodItem(AddFoodItem addFoodItem);

    Optional<FoodItem> updateFoodItem(UpdateFoodItem updateFoodItem);

    List<FoodItem> getAll();
}
