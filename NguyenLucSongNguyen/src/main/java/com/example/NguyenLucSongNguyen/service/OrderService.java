package com.example.NguyenLucSongNguyen.service;

import com.example.NguyenLucSongNguyen.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);
    Optional<Order> getOrderById(Long id);
    Page<Order> getAllOrders(Pageable pageable);
    Order updateOrder(Order order);
    void deleteOrder(Long id);
}