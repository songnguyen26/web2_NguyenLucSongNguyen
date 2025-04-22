package com.example.NguyenLucSongNguyen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.NguyenLucSongNguyen.domain.Product;
import com.example.NguyenLucSongNguyen.dto.ProductDTO;
import com.example.NguyenLucSongNguyen.dto.response.CategoryResponse;
import com.example.NguyenLucSongNguyen.dto.response.ProductResponse;
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
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        
        ProductDTO updateProduct = productService.updateProduct(id, productDTO);
        
        return new ResponseEntity<>(updateProduct,HttpStatus.OK);
    }
    @GetMapping("/products")
    public ResponseEntity<ProductResponse> getAllProducts(
            @RequestParam(name = "pageSize", defaultValue = "10",required = false) Integer pageSize,
            @RequestParam(name = "pageNumber", defaultValue = "0",required = false) Integer pageNumber,
            @RequestParam(name = "sortBy",defaultValue = "productId",required = false) String sortBy,
            @RequestParam(name = "sortOrder",defaultValue = "asc",required = false) String sortOrder){
                ProductResponse productResponse = productService.getAllProducts(pageSize, pageNumber, sortBy, sortOrder);
        return new ResponseEntity<ProductResponse>(productResponse,HttpStatus.OK);
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
