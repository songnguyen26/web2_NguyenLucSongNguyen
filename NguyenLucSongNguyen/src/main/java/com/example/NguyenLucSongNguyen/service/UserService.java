package com.example.NguyenLucSongNguyen.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.NguyenLucSongNguyen.domain.User;
import com.example.NguyenLucSongNguyen.dto.request.UserRequest;

public interface UserService {
    User createUser(User user);
    User updateUser(User user,Long userId);
    String deleteUserById(Long userId);
    Page<User> getALlUsers(Pageable pageable);
    User getUserById(Long userId);
}
