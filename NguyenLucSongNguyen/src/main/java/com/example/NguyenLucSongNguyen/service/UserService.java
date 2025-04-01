package com.example.NguyenLucSongNguyen.service;

import java.util.List;

import com.example.NguyenLucSongNguyen.domain.User;
import com.example.NguyenLucSongNguyen.dto.request.UserRequest;

public interface UserService {
    User createUser(User user);
    User updateUser(User user,Long userId);
    String deleteUserById(Long userId);
    List<User> getALlUsers();
    User getUserById(Long userId);
}
