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
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
       
       Category category = modelMapper.map(categoryDTO, Category.class);
       Category newCategory = categoryRepo.save(category);
       return modelMapper.map(newCategory,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO) {
        Category categoryfromDB = categoryRepo.findById(categoryId).get();
        categoryfromDB.setCategoryName(categoryDTO.getCategoryname());
        categoryfromDB.setImage(categoryDTO.getImage());
        categoryRepo.save(categoryfromDB);
        return modelMapper.map(categoryfromDB, CategoryDTO.class);
    }

    @Override
    public String deleteCategoryById(Long categoryId) {
        categoryRepo.deleteById(categoryId);
        return "Category with Id" + categoryId + " deleted successfull";
        }

    @Override
    public List<Category> getAllCategory() {
        List<Category> lstCategory = categoryRepo.findAll();
        return lstCategory;
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
       Category categoryFromDB = categoryRepo.findById(categoryId).get();
       return modelMapper.map(categoryFromDB, CategoryDTO.class);
    }
    
}
