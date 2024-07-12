package in.codingage.FoodOrdering.model.request.fooditem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateFoodItem {
    private Integer id;
    private Integer restaurantId;
    private Integer ownerId;
    private String name;
    private String description;
    private double price;

}
