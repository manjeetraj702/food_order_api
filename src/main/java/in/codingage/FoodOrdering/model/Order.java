package in.codingage.FoodOrdering.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import in.codingage.FoodOrdering.model.FoodItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "food_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private Integer customerId;

    private Integer restaurantId;

  @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
  @JsonManagedReference
    private List<FoodItem> foodItems;
    private double totalPrice;
    private String status;
}