package in.codingage.FoodOrdering.controller;

import in.codingage.FoodOrdering.model.Order;
import in.codingage.FoodOrdering.model.request.order.CreateOrder;
import in.codingage.FoodOrdering.model.request.order.UpdateOrderStatus;
import in.codingage.FoodOrdering.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody CreateOrder createOrder) {
        return orderService.createOrder(createOrder);
    }
    @GetMapping("/getOrderById")
    Optional<Order> getOrderById(@RequestParam Integer orderId) {
        return orderService.getOrderById(orderId);
    }
    @GetMapping("/getOrderByCustomerId")
    Optional<Order> getOrderByCustomerId(@RequestParam Integer customerId) {
        return orderService.getOrderByCustomerId(customerId);
    }
    @GetMapping("/getOrderByRestaurantId")
    Optional<Order> getOrderByRestaurantId(@RequestParam Integer restaurantId) {
        return orderService.getOrderByRestaurantId(restaurantId);
    }
    @PutMapping("/updateOrder")
    Order updateOrder(@RequestBody UpdateOrderStatus updateOrderStatus) {
        return orderService.updateOrder(updateOrderStatus);
    }

}
