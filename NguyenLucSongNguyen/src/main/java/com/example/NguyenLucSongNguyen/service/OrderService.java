package com.example.NguyenLucSongNguyen.service;

import com.example.NguyenLucSongNguyen.domain.Order;
import com.example.NguyenLucSongNguyen.dto.OrderDTO;
import com.example.NguyenLucSongNguyen.dto.OrderDetailDTO;


public interface OrderService {
    OrderDTO createOrder(String email,Long cartId);
   
}