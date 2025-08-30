package com.projects.shopapp.controllers;

import com.projects.shopapp.dtos.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderContrroller {

    @PostMapping("")
    public ResponseEntity<?> createOrder(
        @Valid @RequestBody OrderDTO orderDTO,
        BindingResult bindingResult
    ) {
        try {
            if (bindingResult.hasErrors()) {
                List<String> errorMessages = bindingResult.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            return ResponseEntity.ok("createOrder successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getOrders(
        @Valid @PathVariable("user_id") Long userId
    ) {
        try {
            return ResponseEntity.ok("Lấy ra danh sách order từ user_id");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(
        @Valid @PathVariable long id,
        @Valid @RequestBody OrderDTO orderDTO
    ) {
        return ResponseEntity.ok("cập nhật thông tin 1 order");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(
        @Valid @PathVariable long id
    ) {
        // xóa mềm => cập nhật trường active = false
        return ResponseEntity.ok("Order deleted successfully");
    }

}
