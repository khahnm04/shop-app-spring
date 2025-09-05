package com.projects.shopapp.services;

import com.projects.shopapp.dtos.OrderDetailDTO;
import com.projects.shopapp.exceptions.DataNotFoundException;
import com.projects.shopapp.models.OrderDetail;
import java.util.*;

public interface IOrderDetailService {

    OrderDetail createOrderDetail(OrderDetailDTO newOrderDetail) throws Exception;

    OrderDetail getOrderDetail(long id) throws DataNotFoundException;

    OrderDetail updateOrderDetail(long id, OrderDetailDTO orderDetailDTO) throws DataNotFoundException;

    void deleteById(long id);

    List<OrderDetail> findByOrderId(long orderId);

}
