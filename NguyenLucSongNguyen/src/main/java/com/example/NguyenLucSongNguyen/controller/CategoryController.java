package com.example.NguyenLucSongNguyen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NguyenLucSongNguyen.domain.Category;
import com.example.NguyenLucSongNguyen.dto.CategoryDTO;
import com.example.NguyenLucSongNguyen.service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO category) {
        CategoryDTO newCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(newCategory,HttpStatus.OK);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO category) {
        CategoryDTO updatedCategory = categoryService.updateCategory(id, category);
        
        return new ResponseEntity<CategoryDTO>(updatedCategory,HttpStatus.OK);
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> lstCategory = categoryService.getAllCategory();
        return new ResponseEntity<List<Category>>( lstCategory,HttpStatus.OK );
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        CategoryDTO category = categoryService.getCategoryById(id);
        return new ResponseEntity<CategoryDTO>(category,HttpStatus.OK);
    }
    @DeleteMapping("/category/{id}")
    public String deleteCategoryById(@PathVariable Long id){
        String notifi = categoryService.deleteCategoryById(id);
        return notifi;
    }
    
}
