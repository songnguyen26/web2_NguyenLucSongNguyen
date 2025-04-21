package com.example.NguyenLucSongNguyen.service;

import com.example.NguyenLucSongNguyen.domain.Role;
import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role getRoleById(Long id);
    List<Role> getAllRoles();
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}