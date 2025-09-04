package com.projects.shopapp.services;

import com.projects.shopapp.dtos.OrderDTO;
import com.projects.shopapp.models.Order;

import java.util.*;

public interface IOrderService {

    Order createOrder(OrderDTO orderDTO) throws Exception;

    Order getOrder(Long id);

    Order updateOrder(Long id, OrderDTO orderDTO);

    void deleteOrder(Long id);

    List<Order> getAllOrders(Long userId);

}
