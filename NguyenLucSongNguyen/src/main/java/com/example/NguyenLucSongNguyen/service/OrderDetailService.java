package com.example.NguyenLucSongNguyen.service;

import com.example.NguyenLucSongNguyen.domain.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetail orderDetail);
    Optional<OrderDetail> getOrderDetailById(Long id);
    Page<OrderDetail> getAllOrderDetails(Pageable pageable);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(Long id);
}