package com.example.NguyenLucSongNguyen.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long orderId;
    private Date orderDate;
    private Double totalPrice;
    private String email;
    private List<OrderDetailDTO> orderItem = new ArrayList<>();

}
