package com.example.NguyenLucSongNguyen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NguyenLucSongNguyen.dto.ProductDTO;
import com.example.NguyenLucSongNguyen.service.ProductService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO newProduct = productService.createProduct(productDTO);
        
        return new ResponseEntity<>(newProduct,HttpStatus.OK);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduc(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        
        ProductDTO updateProduct = productService.updateProduct(id, productDTO);
        
        return new ResponseEntity<>(updateProduct,HttpStatus.OK);
    }
    
}
