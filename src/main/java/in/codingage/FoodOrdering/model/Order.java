package in.codingage.FoodOrdering.model;


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
@Entity(name="food_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private Integer customerId;

    private Integer restaurantId;
//    @ManyToOne
//    @JoinTable(
//            name = "order",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "restaurant_id")
//    )
    private String foodItems;
    private double totalPrice;
    private String status;
}
