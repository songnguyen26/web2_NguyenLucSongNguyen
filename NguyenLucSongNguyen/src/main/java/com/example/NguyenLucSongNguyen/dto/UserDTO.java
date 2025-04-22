package com.example.NguyenLucSongNguyen.dto;

import com.example.NguyenLucSongNguyen.domain.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;
    private RoleDTO role;
    private CartDTO cart;
}
