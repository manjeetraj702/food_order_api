package in.codingage.FoodOrdering.service;

import in.codingage.FoodOrdering.model.Order;
import in.codingage.FoodOrdering.model.request.order.CreateOrder;
import in.codingage.FoodOrdering.model.request.order.UpdateOrderStatus;

import java.util.Optional;

public interface OrderService {
    Order createOrder(CreateOrder createOrder);

    Optional<Order> getOrderById(Integer orderId);

    Optional<Order> getOrderByCustomerId(Integer customerId);

    Optional<Order> getOrderByRestaurantId(Integer restaurantId);

    Order updateOrder(UpdateOrderStatus updateOrderStatus);

}
