package com.example.NguyenLucSongNguyen.controller;

import com.example.NguyenLucSongNguyen.domain.Order;
import com.example.NguyenLucSongNguyen.dto.CartDTO;
import com.example.NguyenLucSongNguyen.dto.OrderDTO;
import com.example.NguyenLucSongNguyen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import org.springframework.data.web.PageableDefault;
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/public/order/email/{email}/cartId{cartId}")
    public ResponseEntity<OrderDTO> createOrder(@PathVariable(name = "email") String email, @PathVariable(name = "cartId") Long cartId) {
        OrderDTO order = orderService.createOrder(email, cartId);
        return new ResponseEntity<OrderDTO>(order, HttpStatus.OK);
    }
}