package com.example.NguyenLucSongNguyen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NguyenLucSongNguyen.domain.Brand;
import com.example.NguyenLucSongNguyen.dto.BrandDTO;
import com.example.NguyenLucSongNguyen.service.BrandService;

import java.util.List;

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
    public ResponseEntity<BrandDTO> createBrand(@RequestBody Brand brand) {
        BrandDTO newBrand = brandService.createBrand(brand);
        
        return new ResponseEntity<BrandDTO>(newBrand,HttpStatus.OK);
    }
    @PutMapping("/brand/{id}")
    public ResponseEntity<BrandDTO> upadteBrand(@PathVariable Long id, @RequestBody Brand brand) {
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
    public ResponseEntity<List<Brand>> getAllBrand() {
        List<Brand> lstbrand = brandService.getAllBrand();
        return new ResponseEntity<List<Brand>>(lstbrand,HttpStatus.OK);
    }
    @DeleteMapping("/brand/{id}")
    public ResponseEntity<String> delteBrandById(@PathVariable Long id){
        String deleteNoti = brandService.deleteBrandById(id);
        return new ResponseEntity<String>(deleteNoti,HttpStatus.OK);
    }
    
    
}
