package com.example.NguyenLucSongNguyen.service;

import java.util.List;
import java.util.Optional;

import com.example.NguyenLucSongNguyen.domain.Category;

public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Long categoryId,Category category);
    String deleteCategoryById(Long categoryId);
    List<Category> getAllCategory();
    Optional<Category> getCategoryById(Long categoryId);
}
