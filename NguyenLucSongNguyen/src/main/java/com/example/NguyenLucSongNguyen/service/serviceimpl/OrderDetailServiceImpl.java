package com.example.NguyenLucSongNguyen.service.serviceimpl;

import com.example.NguyenLucSongNguyen.domain.OrderDetail;
import com.example.NguyenLucSongNguyen.repository.OrderDetailRepo;
import com.example.NguyenLucSongNguyen.service.OrderDetailService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepo.save(orderDetail);
    }

    @Override
    public Optional<OrderDetail> getOrderDetailById(Long id) {
        return orderDetailRepo.findById(id);
    }

    @Override
    public Page<OrderDetail> getAllOrderDetails(Pageable pageable) {
        return orderDetailRepo.findAll(pageable);
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepo.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(Long id) {
        orderDetailRepo.deleteById(id);
    }
}