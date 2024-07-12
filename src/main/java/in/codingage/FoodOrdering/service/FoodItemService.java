package in.codingage.FoodOrdering.service;

import in.codingage.FoodOrdering.model.FoodItem;

public interface FoodItemService {
    FoodItem addFoodItem(FoodItem foodItem);
    FoodItem updateFoodItem(Integer ownerId,String FoodItemId,FoodItem f);
}
