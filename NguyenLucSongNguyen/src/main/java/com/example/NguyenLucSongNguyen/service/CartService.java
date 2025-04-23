package com.example.NguyenLucSongNguyen.service;

import com.example.NguyenLucSongNguyen.dto.CartDTO;

public interface CartService {
    CartDTO addProductToCart(Long productId,Long cartId,Integer quantity);
    CartDTO getCartById(Long cartId);
    String deleteCartItemByCartIdAndProductId(Long cartId,Long productId);
}