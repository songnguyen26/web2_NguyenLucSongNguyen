package com.example.NguyenLucSongNguyen.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.NguyenLucSongNguyen.domain.User;
import com.example.NguyenLucSongNguyen.dto.UserDTO;
import com.example.NguyenLucSongNguyen.dto.request.UserRequest;
import com.example.NguyenLucSongNguyen.dto.response.UserResponse;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO,Long userId);
    String deleteUserById(Long userId);
    UserResponse getALlUsers(Integer pageSize,Integer pageNumber, String sortBy, String sortOrder);
    UserDTO getUserById(Long userId);
}
