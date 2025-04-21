package com.example.NguyenLucSongNguyen.service;

import com.example.NguyenLucSongNguyen.domain.OrderDetail;
import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    OrderDetail createOrderDetail(OrderDetail orderDetail);
    Optional<OrderDetail> getOrderDetailById(Long id);
    List<OrderDetail> getAllOrderDetails();
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(Long id);
}