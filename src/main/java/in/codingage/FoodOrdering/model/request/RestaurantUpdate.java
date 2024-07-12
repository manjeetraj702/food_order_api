package in.codingage.FoodOrdering.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantUpdate {
    private Integer restaurantId;
    private Integer ownerId;
    private String name;
    private String address;
    private String phone;
}
