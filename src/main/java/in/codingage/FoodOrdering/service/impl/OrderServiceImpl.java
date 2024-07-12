package in.codingage.FoodOrdering.service.impl;

import in.codingage.FoodOrdering.model.FoodItem;
import in.codingage.FoodOrdering.model.Order;
import in.codingage.FoodOrdering.model.Restaurant;
import in.codingage.FoodOrdering.model.User;
import in.codingage.FoodOrdering.model.request.order.CreateOrder;
import in.codingage.FoodOrdering.model.request.order.UpdateOrderStatus;
import in.codingage.FoodOrdering.repository.OrderRepository;
import in.codingage.FoodOrdering.service.FoodItemService;
import in.codingage.FoodOrdering.service.OrderService;
import in.codingage.FoodOrdering.service.RestaurantService;
import in.codingage.FoodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    FoodItemService foodItemService;
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    UserService userService;

    @Override
    public Optional<Order> getOrderById(Integer orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public Optional<Order> getOrderByCustomerId(Integer customerId) {
        return Optional.ofNullable(orderRepository.findByCustomerId(customerId));
    }

    @Override
    public Optional<Order> getOrderByRestaurantId(Integer restaurantId) {
        return Optional.ofNullable(orderRepository.findByRestaurantId(restaurantId));
    }

    @Override
    public Order createOrder(CreateOrder createOrder) {
        Restaurant restaurant = restaurantService.getRestaurantById(createOrder.getRestaurantId());
        Optional<User> user = userService.getById(createOrder.getCustomerId());
        if (restaurant != null && user.isPresent() && user.get().getRole().equalsIgnoreCase("customer"))
            for (FoodItem foodItem : restaurant.getFoodItemList()) {
                if (foodItem.getId().equals(createOrder.getFoodItemId())) {
                    Order order = new Order();
                    order.setRestaurantId(createOrder.getRestaurantId());
                    order.setCustomerId(createOrder.getCustomerId());
                    order.setFoodItem(createOrder.getFoodItemId());
                    order.setTotalPrice(foodItem.getPrice());
                    order.setStatus("In_progress");
                    return orderRepository.save(order);
                }
            }
        return new Order();
    }

    @Override
    public Order updateOrder(UpdateOrderStatus updateOrderStatus) {
        Order order = orderRepository.getReferenceById(updateOrderStatus.getOrderId());
        if (updateOrderStatus.getOrderId().equals(order.getId())) {
            order.setStatus(updateOrderStatus.getStatus());
        }
        return new Order();
    }
}
