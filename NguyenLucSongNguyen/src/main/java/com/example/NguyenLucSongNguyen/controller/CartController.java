package com.example.NguyenLucSongNguyen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NguyenLucSongNguyen.dto.CartDTO;
import com.example.NguyenLucSongNguyen.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    CartService cartService;
    @PostMapping("/public/cartId/{cartId}/product/{productId}/quantity/{quantity}")
    public ResponseEntity<CartDTO> addProductToCart (@PathVariable(name = "cartId") Long cartId,@PathVariable(name = "productId") Long productId,@PathVariable(name = "quantity") Integer quantity) {
        CartDTO cartDTO = cartService.addProductToCart(productId, cartId, quantity);
        
        return new ResponseEntity<CartDTO>(cartDTO,HttpStatus.OK);
    }
    @GetMapping("/public/cart/{id}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable(name = "id") Long id) {
        CartDTO cartDTO = cartService.getCartById(id);
        return new ResponseEntity<CartDTO>(cartDTO,HttpStatus.OK);
    }
    @DeleteMapping("/public/cart/{cartId}/product/{id}")
    public ResponseEntity<String> deleteCartItem(@PathVariable(name = "cartId") Long cartId,@PathVariable(name = "id") Long productId){
        String notify = cartService.deleteCartItemByCartIdAndProductId(cartId, productId);
        return new ResponseEntity<String>(notify,HttpStatus.OK);
    }
    
}
