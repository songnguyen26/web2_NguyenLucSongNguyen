package com.example.NguyenLucSongNguyen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.NguyenLucSongNguyen.domain.Product;
import com.example.NguyenLucSongNguyen.dto.ProductDTO;
import com.example.NguyenLucSongNguyen.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getAllProduct(Pageable pageable) {
        Page<Product> productPage = productService.getAllProduct(pageable);
        return new ResponseEntity<>(productPage,HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO product = productService.getProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        String notifi = productService.deleteProductById(id);
        return new ResponseEntity<>(notifi,HttpStatus.OK);
    }
    
}
