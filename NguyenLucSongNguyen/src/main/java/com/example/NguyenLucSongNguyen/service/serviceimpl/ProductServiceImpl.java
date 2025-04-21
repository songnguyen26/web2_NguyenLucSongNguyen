package com.example.NguyenLucSongNguyen.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.NguyenLucSongNguyen.domain.Brand;
import com.example.NguyenLucSongNguyen.domain.Category;
import com.example.NguyenLucSongNguyen.domain.Product;
import com.example.NguyenLucSongNguyen.dto.ProductDTO;
import com.example.NguyenLucSongNguyen.repository.BrandRepo;
import com.example.NguyenLucSongNguyen.repository.CategoryRepo;
import com.example.NguyenLucSongNguyen.repository.ProductRepo;
import com.example.NguyenLucSongNguyen.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService  {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    BrandRepo brandRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Category category = categoryRepo.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category Not Found"));
        Brand brand = brandRepo.findById(productDTO.getBrandId()).orElseThrow(() -> new RuntimeException("Brand Not Found"));
        Product product = modelMapper.map(productDTO,Product.class);
        product.setCategory(category);
        product.setBrand(brand);
        Product newProduct = productRepo.save(product);
        
        return modelMapper.map(newProduct,ProductDTO.class);
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepo.findAll(pageable);}

    @Override
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        Product productFromDB = productRepo.findById(productId).orElseThrow(()-> new RuntimeException("Product not found with id: " + productId));
        Category category = categoryRepo.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category Not Found"));
        Brand brand = brandRepo.findById(productDTO.getBrandId()).orElseThrow(() -> new RuntimeException("Brand Not Found"));
        productFromDB.setProductName(productDTO.getProductName());
        productFromDB.setDescription(productDTO.getDescription());
        productFromDB.setBrand(brand);
        productFromDB.setCategory(category);
        productFromDB.setDescription(productDTO.getDescription());
        productFromDB.setDiscount(productDTO.getDiscount());
        productFromDB.setImportPrice(productDTO.getImportPrice());
        productFromDB.setSellingPrice(productDTO.getSellingPrice());
        productFromDB.setQuantity(productDTO.getQuantity());
        Product savedProduct = productRepo.save(productFromDB);
        return modelMapper.map(savedProduct,ProductDTO.class);
        
    }

    @Override
    public String deleteProduct(Long productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductById'");
    }
    
}
