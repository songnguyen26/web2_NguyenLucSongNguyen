package com.example.NguyenLucSongNguyen.service.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.NguyenLucSongNguyen.domain.Brand;
import com.example.NguyenLucSongNguyen.domain.Category;
import com.example.NguyenLucSongNguyen.domain.Product;
import com.example.NguyenLucSongNguyen.dto.ProductDTO;
import com.example.NguyenLucSongNguyen.dto.response.ProductResponse;
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
    public String deleteProductById(Long productId) {
        productRepo.deleteById(productId);
        return "Product with id "+ productId +" deleted successful";
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(()-> new RuntimeException("Product not found with id: " + productId));
        return modelMapper.map(product,ProductDTO.class);
    }


    @Override
    public ProductResponse getAllProducts(Integer pageSize, Integer pageNumber, String sortBy, String sortOrder) {
      Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
      Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
      Page<Product> pageProducts = productRepo.findAll(pageDetails);
      List<Product> products = pageProducts.getContent();
      if(products.size() ==0){
        throw new RuntimeException("No product created till now");
      }
      List<ProductDTO> productDTOs = products.stream().map(product -> modelMapper.map(product,ProductDTO.class)).collect(Collectors.toList());
      ProductResponse productResponse = new ProductResponse();
      productResponse.setContent(productDTOs);
      productResponse.setPageNumber(pageProducts.getNumber());
      productResponse.setPageSize(pageProducts.getSize());
      productResponse.setTotalElements(pageProducts.getTotalElements());
      productResponse.setTotalPage(pageProducts.getTotalPages());
      productResponse.setLastPage(pageProducts.isLast());
      return productResponse;
    }
    
}
