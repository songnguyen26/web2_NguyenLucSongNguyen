package com.example.NguyenLucSongNguyen.repository;

import com.example.NguyenLucSongNguyen.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}