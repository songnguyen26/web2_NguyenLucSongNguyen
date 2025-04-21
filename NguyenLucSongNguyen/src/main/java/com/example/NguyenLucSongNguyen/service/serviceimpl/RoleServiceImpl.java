package com.example.NguyenLucSongNguyen.service.serviceimpl;

import com.example.NguyenLucSongNguyen.domain.Role;
import com.example.NguyenLucSongNguyen.repository.RoleRepo;
import com.example.NguyenLucSongNguyen.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> optionalRole = roleRepo.findById(id);
        return optionalRole.orElse(null);
    }

    @Override
    public Page<Role> getAllRoles(Pageable pageable) {
        return roleRepo.findAll(pageable);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Optional<Role> optionalRole = roleRepo.findById(id);
        if (optionalRole.isPresent()) {
            Role existingRole = optionalRole.get();
            existingRole.setRoleName(role.getRoleName());
            return roleRepo.save(existingRole);
        }
        return null;
    }

    @Override
    public void deleteRole(Long id) {
        roleRepo.deleteById(id);
    }
}