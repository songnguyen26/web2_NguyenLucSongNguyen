package com.example.NguyenLucSongNguyen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    private Long orderDetailId;
    private Integer quantity;
    private Double price;
    private ProductDTO product;
}
