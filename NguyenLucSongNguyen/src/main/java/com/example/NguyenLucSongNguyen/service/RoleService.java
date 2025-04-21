package com.example.NguyenLucSongNguyen.service;

import com.example.NguyenLucSongNguyen.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {
    Role createRole(Role role);
    Role getRoleById(Long id);
    Page<Role> getAllRoles(Pageable pageable);
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}