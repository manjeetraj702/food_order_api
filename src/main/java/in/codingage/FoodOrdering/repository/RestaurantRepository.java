package in.codingage.FoodOrdering.repository;

import in.codingage.FoodOrdering.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Restaurant findByPhone(String phone);

    List<Restaurant> findRestaurantByOwnerId(Integer ownerId);
}
