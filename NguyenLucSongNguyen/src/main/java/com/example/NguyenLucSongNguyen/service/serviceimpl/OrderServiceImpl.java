package com.example.NguyenLucSongNguyen.service.serviceimpl;

import com.example.NguyenLucSongNguyen.domain.Cart;
import com.example.NguyenLucSongNguyen.domain.CartItem;
import com.example.NguyenLucSongNguyen.domain.Order;
import com.example.NguyenLucSongNguyen.domain.OrderDetail;
import com.example.NguyenLucSongNguyen.domain.Product;
import com.example.NguyenLucSongNguyen.dto.OrderDTO;
import com.example.NguyenLucSongNguyen.dto.OrderDetailDTO;
import com.example.NguyenLucSongNguyen.repository.CartRepo;
import com.example.NguyenLucSongNguyen.repository.OrderDetailRepo;
import com.example.NguyenLucSongNguyen.repository.OrderRepo;
import com.example.NguyenLucSongNguyen.service.CartService;
import com.example.NguyenLucSongNguyen.service.OrderService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CartService cartService;
    @Override
    public OrderDTO createOrder(String email, Long cartId) {
        Cart cart = cartRepo.FindCartByEmailAndCartId(email, cartId);
        if(cart == null ){
            throw new RuntimeException("Cart not found");
        }
        Order order = new Order();
        order.setEmail(email);
        order.setOrderDate(LocalDate.now());
        order.setTotalPrice(cart.getTotalPrice());
        
        Order savedOrder = orderRepo.save(order);
        List<CartItem> cartItems = cart.getCartItems();
        if(cartItems.size() == 0){
            throw new RuntimeException("Cart is empty");
        }
        List<OrderDetail> orderDetails = new ArrayList<>();
        for(CartItem cartItem : cartItems){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setPrice(cartItem.getProductPrice());
            orderDetail.setQuantity(cartItem.getQuantity());
            orderDetail.setProduct(cartItem.getProduct());
            orderDetail.setOrder(savedOrder);
            orderDetails.add(orderDetail);
        }
        orderDetails = orderDetailRepo.saveAll(orderDetails);
        cart.getCartItems().forEach(item ->{
            int quantity = item.getQuantity();
            Product product = item.getProduct();
            cartService.deleteCartItemByCartIdAndProductId(cartId, product.getProductId());
            product.setQuantity(product.getQuantity() - quantity);
        });
        OrderDTO orderDTO = modelMapper.map(savedOrder,OrderDTO.class);
        orderDetails.forEach(item -> orderDTO.getOrderItem().add(modelMapper.map(item,OrderDetailDTO.class)));
        return orderDTO;
    }
   
    

}