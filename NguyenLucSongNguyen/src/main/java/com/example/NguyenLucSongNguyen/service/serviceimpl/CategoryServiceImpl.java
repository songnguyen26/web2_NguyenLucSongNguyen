package com.example.NguyenLucSongNguyen.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NguyenLucSongNguyen.domain.Category;
import com.example.NguyenLucSongNguyen.dto.CategoryDTO;
import com.example.NguyenLucSongNguyen.dto.response.CategoryResponse;
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
    public CategoryResponse getAllCategory(Integer pageSize, Integer pageNumber,String sortBy,String sortOrder) {
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Category> pageCategories = categoryRepo.findAll(pageDetails);
        List<Category> categories = pageCategories.getContent();
        if(categories.size()==0){
            throw new RuntimeException("No category created till now");
        }
        List<CategoryDTO> categoryDTOs = categories.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOs);
        categoryResponse.setPageNumber(pageCategories.getNumber());
        categoryResponse.setPageSize(pageCategories.getSize());
        categoryResponse.setTotalElements(pageCategories.getTotalElements());
        categoryResponse.setTotalPages(pageCategories.getTotalPages());
        categoryResponse.setLastPage(pageCategories.isLast());
        return categoryResponse;

    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
       Category categoryFromDB = categoryRepo.findById(categoryId).get();
       return modelMapper.map(categoryFromDB, CategoryDTO.class);
    }
    
}
