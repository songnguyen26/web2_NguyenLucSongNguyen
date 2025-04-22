package com.example.NguyenLucSongNguyen.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import com.example.NguyenLucSongNguyen.domain.Category;
import com.example.NguyenLucSongNguyen.dto.CategoryDTO;
import com.example.NguyenLucSongNguyen.dto.response.CategoryResponse;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);
    String deleteCategoryById(Long categoryId);
    CategoryResponse getAllCategory(Integer pageNumber,Integer pageSize,String sortBy,String sortOrder);
    CategoryDTO getCategoryById(Long categoryId);
}
