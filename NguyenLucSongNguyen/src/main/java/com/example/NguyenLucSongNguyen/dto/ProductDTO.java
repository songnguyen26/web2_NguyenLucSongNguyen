package com.example.NguyenLucSongNguyen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long productId;
    private String productName;
    private Double importPrice;
    private Double sellingPrice;
    private Integer discount;
    private String image;
    private String description;
    private Integer quantity;
    private Long categoryId;
    private Long brandId;
    private CategoryDTO category;
    private BrandDTO brand;
}
