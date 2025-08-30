package com.projects.shopapp.controllers;

import com.projects.shopapp.dtos.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {

    @PostMapping("")
    public ResponseEntity<?> createOrderDetail(
        @Valid @RequestBody OrderDetailDTO orderDetailDTO
    ) {
        return ResponseEntity.ok("createOrderDetail here");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetail(
        @Valid @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok("getOrderDetail with id = " + id);
    }

    // Lấy ra danh sách các order_details của 1 order nào đó
    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderDetails(
        @Valid @PathVariable("orderId") Long orderId
    ) {
        return ResponseEntity.ok("getOrderDetails with id = " + orderId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(
        @Valid @PathVariable("id") Long id,
        @RequestBody OrderDetailDTO newOrderDetailData
    ) {
        return ResponseEntity.ok("updateOrderDetails with id = " + id + ", newOrderDetailData:  " + newOrderDetailData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(
        @Valid @PathVariable("id") Long id
    ) {
        return ResponseEntity.noContent().build();
    }

}
