package com.example.NguyenLucSongNguyen.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NguyenLucSongNguyen.domain.Brand;
import com.example.NguyenLucSongNguyen.dto.BrandDTO;
import com.example.NguyenLucSongNguyen.repository.BrandRepo;
import com.example.NguyenLucSongNguyen.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepo brandRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public BrandDTO createBrand(Brand brand) {
        Brand newBrand = brandRepo.save(brand);
       return modelMapper.map(newBrand,BrandDTO.class);
    }

    @Override
    public BrandDTO updateBrand(Long brandId, Brand brand) {
        Brand brandUpdate = brandRepo.findById(brandId).get();
        brandUpdate.setBrandName(brand.getBrandName());
        brandUpdate.setImage(brand.getImage());
        brandRepo.save(brandUpdate);
        return modelMapper.map(brandUpdate,BrandDTO.class);
    }

    @Override
    public String deleteBrandById(Long brandId) {
       brandRepo.deleteById(brandId);
       return "Brand with id "+ brandId +" deleted successfull";
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandRepo.findAll();
    }

    @Override
    public BrandDTO getBrandById(Long brandId) {
        Optional<Brand> brand = brandRepo.findById(brandId);
        return modelMapper.map(brand.get(), BrandDTO.class);
    }
    
}
