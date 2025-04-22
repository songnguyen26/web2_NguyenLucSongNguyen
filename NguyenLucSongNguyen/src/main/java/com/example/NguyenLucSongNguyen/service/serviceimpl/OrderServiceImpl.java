// package com.example.NguyenLucSongNguyen.service.serviceimpl;

// import com.example.NguyenLucSongNguyen.domain.Order;
// import com.example.NguyenLucSongNguyen.repository.OrderRepo;
// import com.example.NguyenLucSongNguyen.service.OrderService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class OrderServiceImpl implements OrderService {

//     @Autowired
//     private OrderRepo orderRepo;

//     @Override
//     public Order createOrder(Order order) {
//         return orderRepo.save(order);
//     }

//     @Override
//     public Optional<Order> getOrderById(Long id) {
//         return orderRepo.findById(id);
//     }

//     @Override
//     public Page<Order> getAllOrders(Pageable pageable) {
//         return orderRepo.findAll(pageable);
//     }

//     @Override
//     public Order updateOrder(Order order) {
//         Optional<Order> existingOrder = orderRepo.findById(order.getOrderId());
//         if (existingOrder.isPresent()) {
//             Order updatedOrder = existingOrder.get();
//             updatedOrder.setTotalPrice(order.getTotalPrice());
//             updatedOrder.setOrderDate(order.getOrderDate());
//             updatedOrder.setUser(order.getUser());
//             updatedOrder.setOrderDetails(order.getOrderDetails());
//             return orderRepo.save(updatedOrder);
//         }
//         return null;
//     }

//     @Override
//     public void deleteOrder(Long id) {
//         orderRepo.deleteById(id);
//     }
// }