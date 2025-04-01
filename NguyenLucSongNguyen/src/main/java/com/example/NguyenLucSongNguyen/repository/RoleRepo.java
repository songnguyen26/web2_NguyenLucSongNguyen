package com.example.NguyenLucSongNguyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NguyenLucSongNguyen.domain.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    
}
