package com.example.NguyenLucSongNguyen.dto.response;

import java.util.List;

import com.example.NguyenLucSongNguyen.dto.BrandDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandResponse {
    private List<BrandDTO> content;
    private Integer pageSize;
    private Integer pageNumber;
    private Long totalElements;
    private Integer totalPages;
    private boolean lastPage;
}
