package com.example.NguyenLucSongNguyen.service.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.NguyenLucSongNguyen.domain.Brand;
import com.example.NguyenLucSongNguyen.dto.BrandDTO;
import com.example.NguyenLucSongNguyen.dto.response.BrandResponse;
import com.example.NguyenLucSongNguyen.repository.BrandRepo;
import com.example.NguyenLucSongNguyen.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepo brandRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public BrandDTO createBrand(BrandDTO brandDTO) {
        Brand brand = modelMapper.map(brandDTO,Brand.class);
        Brand newBrand = brandRepo.save(brand);
       return modelMapper.map(newBrand,BrandDTO.class);
    }

    @Override
    public BrandDTO updateBrand(Long brandId, BrandDTO brandDTO) {
        Brand brandUpdate = brandRepo.findById(brandId).get();
        brandUpdate.setBrandName(brandDTO.getBrandName());
        brandUpdate.setImage(brandDTO.getImage());
        brandRepo.save(brandUpdate);
        return modelMapper.map(brandUpdate,BrandDTO.class);
    }

    @Override
    public String deleteBrandById(Long brandId) {
       brandRepo.deleteById(brandId);
       return "Brand with id "+ brandId +" deleted successfull";
    }


    @Override
    public BrandDTO getBrandById(Long brandId) {
        Optional<Brand> brand = brandRepo.findById(brandId);
        return modelMapper.map(brand.get(), BrandDTO.class);
    }

    @Override
    public BrandResponse getAllBrand(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<Brand> pageBrands = brandRepo.findAll(pageDetails);
        List<Brand> brands = pageBrands.getContent();
        if(brands.size() == 0){
            throw new RuntimeException("no Brand created till now!");
        }
        List<BrandDTO> brandDTOs = brands.stream().map(brand -> modelMapper.map(brand,BrandDTO.class)).collect(Collectors.toList());
        BrandResponse brandResponse = new BrandResponse();
        brandResponse.setContent(brandDTOs);
        brandResponse.setPageNumber(pageBrands.getNumber());
        brandResponse.setPageSize(pageBrands.getSize());
        brandResponse.setTotalElements(pageBrands.getTotalElements());
        brandResponse.setTotalPages(pageBrands.getTotalPages());
        brandResponse.setLastPage(pageBrands.isLast());
        return brandResponse;
    }
    
}
