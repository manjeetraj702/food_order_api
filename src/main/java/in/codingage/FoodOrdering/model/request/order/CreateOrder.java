package in.codingage.FoodOrdering.model.request.order;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrder {
    private Integer customerId;

    private Integer restaurantId;

    private Integer foodItemId;
}
