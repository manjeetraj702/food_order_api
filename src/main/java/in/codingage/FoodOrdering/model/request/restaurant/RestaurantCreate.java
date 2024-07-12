package in.codingage.FoodOrdering.model.request.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RestaurantCreate {
    private Integer ownerId;
    private String name;
    private String address;
    private String phone;
}
