package com.example.NguyenLucSongNguyen.repository;

import com.example.NguyenLucSongNguyen.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
}