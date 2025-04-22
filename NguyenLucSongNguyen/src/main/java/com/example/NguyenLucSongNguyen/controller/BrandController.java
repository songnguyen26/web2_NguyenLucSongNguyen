package com.example.NguyenLucSongNguyen.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NguyenLucSongNguyen.domain.Brand;
import com.example.NguyenLucSongNguyen.dto.BrandDTO;
import com.example.NguyenLucSongNguyen.dto.response.BrandResponse;
import com.example.NguyenLucSongNguyen.service.BrandService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api")
public class BrandController {
    @Autowired
    BrandService brandService;
    @PostMapping("/brand")
    public ResponseEntity<BrandDTO> createBrand(@RequestBody BrandDTO brand) {
        BrandDTO newBrand = brandService.createBrand(brand);
        
        return new ResponseEntity<BrandDTO>(newBrand,HttpStatus.OK);
    }
    @PutMapping("/brand/{id}")
    public ResponseEntity<BrandDTO> upadteBrand(@PathVariable Long id, @RequestBody BrandDTO brand) {
        //TODO: process PUT request
        BrandDTO updatedBrand = brandService.updateBrand(id, brand);
        return new ResponseEntity<BrandDTO>(updatedBrand,HttpStatus.OK);
    }
    @GetMapping("/brand/{id}")
    public ResponseEntity<BrandDTO> getBrandById(@PathVariable Long id) {
        BrandDTO brand = brandService.getBrandById(id);
        return new ResponseEntity<BrandDTO>(brand,HttpStatus.OK);
    }
    @GetMapping("/brands")
    public ResponseEntity<BrandResponse> getAllBrand(@RequestParam(name = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
    @RequestParam(name = "pageSize", defaultValue = "10",required = false) Integer pageSize,
    @RequestParam(name = "sortBy",defaultValue = "id",required = false) String sortBy,
    @RequestParam(name = "sortOrder",defaultValue = "asc",required = false) String sortOrder) {
        BrandResponse brandResponse = brandService.getAllBrand(pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<BrandResponse>(brandResponse, HttpStatus.OK);
    }
    @DeleteMapping("/brand/{id}")
    public ResponseEntity<String> delteBrandById(@PathVariable Long id){
        String deleteNoti = brandService.deleteBrandById(id);
        return new ResponseEntity<String>(deleteNoti,HttpStatus.OK);
    }
    
    
}
