package in.codingage.FoodOrdering.repository;

import in.codingage.FoodOrdering.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findByCustomerId(Integer customerId);

    Order findByRestaurantId(Integer restaurantId);
}
