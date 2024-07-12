package in.codingage.FoodOrdering.service.impl;

import in.codingage.FoodOrdering.model.FoodItem;
import in.codingage.FoodOrdering.model.Order;
import in.codingage.FoodOrdering.model.request.order.CreateOrder;
import in.codingage.FoodOrdering.model.request.order.UpdateOrderStatus;
import in.codingage.FoodOrdering.repository.OrderRepository;
import in.codingage.FoodOrdering.service.OrderService;
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
    FoodItemServiceImpl foodItemService;

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
        Order order = new Order();
        order.setStatus("In_progress");
        order.setCustomerId(createOrder.getCustomerId());
        order.setRestaurantId(createOrder.getRestaurantId());
        double d=0;
        for (FoodItem foodItem : foodItemService.getAll()) {
            if (foodItem.getId().equals(createOrder.getFoodItemId())) {
                List<FoodItem> foodItems = new ArrayList<>();
                foodItems.add(foodItem);
                d+=foodItem.getPrice();
                order.setFoodItems(foodItems);
            }
        }

        order.setTotalPrice(d);
        orderRepository.save(order);
        return order;
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
