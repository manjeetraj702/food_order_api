package in.codingage.FoodOrdering.repository;

import in.codingage.FoodOrdering.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
    FoodItem findByRestaurantId(Integer restaurantId);
}
