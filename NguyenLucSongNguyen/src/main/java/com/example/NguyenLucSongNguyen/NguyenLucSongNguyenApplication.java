package com.example.NguyenLucSongNguyen;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.NguyenLucSongNguyen.domain.Role;
import com.example.NguyenLucSongNguyen.repository.RoleRepo;

@SpringBootApplication
public class NguyenLucSongNguyenApplication implements CommandLineRunner {
	@Autowired
	private RoleRepo roleRepo;
	public static void main(String[] args) {
		SpringApplication.run(NguyenLucSongNguyenApplication.class, args);
	}
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	@Override
	public void run(String... args) throws Exception {
		try{
			Role adminRole = new Role();
			adminRole.setRoleId(1);
			adminRole.setRoleName("ADMIN");
			Role userRole = new Role();
			userRole.setRoleId(2);
			userRole.setRoleName("USER");
			List<Role> roles = List.of(adminRole, userRole);
			List<Role> savedRole = roleRepo.saveAll(roles);
			savedRole.forEach(System.out::println);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
