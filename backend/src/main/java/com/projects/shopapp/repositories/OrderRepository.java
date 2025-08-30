package com.projects.shopapp.repositories;

import com.projects.shopapp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Tìm các đơn hàng của 1 user nào đó
    List<Order> findByUserId(Long userId);

}
