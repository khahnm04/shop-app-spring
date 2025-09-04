package com.projects.shopapp.services;

import com.projects.shopapp.dtos.OrderDTO;
import com.projects.shopapp.exceptions.DataNotFoundException;
import com.projects.shopapp.models.*;
import com.projects.shopapp.repositories.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public Order createOrder(OrderDTO orderDTO) throws Exception {
        // Check if user_id exists
        User user = userRepository
                .findById(orderDTO.getUserId())
                .orElseThrow(() -> new DataNotFoundException("Cannot find user with id: " + orderDTO.getUserId()));
        // convert orderDTO -> Order, skip the 'id' field
        modelMapper.typeMap(OrderDTO.class, Order.class)
                .addMappings(mapper -> mapper.skip(Order::setId));
        // Update the fields of the order from orderDTO
        Order order = new Order();
        modelMapper.map(orderDTO, order);
        order.setUser(user);
        order.setOrderDate(new Date());
        order.setStatus(OrderStatus.PENDING);
        order.setActive(true);
        // Check if shipping date is greater than or equal to yesterday
        LocalDate shippingDate = orderDTO.getShippingDate() == null ? LocalDate.now() : orderDTO.getShippingDate();
        if (shippingDate.isBefore(LocalDate.now())) {
            throw new DataNotFoundException("Date must be at least today!");
        }
        order.setShippingDate(shippingDate);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order getOrder(Long id) {
        return null;
    }

    @Override
    public Order updateOrder(Long id, OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }

    @Override
    public List<Order> getAllOrders(Long userId) {
        return List.of();
    }

}
