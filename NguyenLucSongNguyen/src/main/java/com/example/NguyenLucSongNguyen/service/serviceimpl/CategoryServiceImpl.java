package com.example.NguyenLucSongNguyen.service.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NguyenLucSongNguyen.domain.Category;
import com.example.NguyenLucSongNguyen.dto.CategoryDTO;
import com.example.NguyenLucSongNguyen.repository.CategoryRepo;
import com.example.NguyenLucSongNguyen.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public CategoryDTO createCategory(Category category) {
       Category newCategory = categoryRepo.save(category);
       return modelMapper.map(newCategory,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(Long categoryId, Category category) {
        Category categoryfromDB = categoryRepo.findById(categoryId).get();
        categoryfromDB.setCategoryName(category.getCategoryName());
        categoryfromDB.setImage(category.getImage());
        categoryRepo.save(categoryfromDB);
        return modelMapper.map(categoryfromDB, CategoryDTO.class);
    }

    @Override
    public String deleteCategoryById(Long categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategoryById'");
    }

    @Override
    public List<Category> getAllCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCategory'");
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
       Category categoryFromDB = categoryRepo.findById(categoryId).get();
       return modelMapper.map(categoryFromDB, CategoryDTO.class);
    }
    
}
