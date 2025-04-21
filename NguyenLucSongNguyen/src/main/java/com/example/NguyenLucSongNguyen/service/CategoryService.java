package com.example.NguyenLucSongNguyen.service;

import java.util.List;
import java.util.Optional;

import com.example.NguyenLucSongNguyen.domain.Category;
import com.example.NguyenLucSongNguyen.dto.CategoryDTO;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);
    String deleteCategoryById(Long categoryId);
    List<Category> getAllCategory();
    CategoryDTO getCategoryById(Long categoryId);
}
