package com.example.NguyenLucSongNguyen.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.NguyenLucSongNguyen.domain.User;
import com.example.NguyenLucSongNguyen.dto.UserDTO;
import com.example.NguyenLucSongNguyen.dto.response.ProductResponse;
import com.example.NguyenLucSongNguyen.dto.response.UserResponse;
import com.example.NguyenLucSongNguyen.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        UserDTO newUser = userService.createUser(user);
        
        return new ResponseEntity<UserDTO>(newUser,HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO user) {
        userService.updateUser(user, id);
        return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
    }
    @DeleteMapping("/admin/user/{id}")
    public String deleteUser(@PathVariable Long id){
        String deleted = userService.deleteUserById(id);
        return deleted;
    }
    @GetMapping("/admin/users")
    public ResponseEntity<UserResponse> getAllUsers(
         @RequestParam(name = "pageSize", defaultValue = "10",required = false) Integer pageSize,
            @RequestParam(name = "pageNumber", defaultValue = "0",required = false) Integer pageNumber,
            @RequestParam(name = "sortBy",defaultValue = "userId",required = false) String sortBy,
            @RequestParam(name = "sortOrder",defaultValue = "asc",required = false) String sortOrder){
                UserResponse userResponse = userService.getALlUsers(pageSize, pageNumber, sortBy, sortOrder);
        return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
    }
    @GetMapping("/public/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return new ResponseEntity<UserDTO>(user,HttpStatus.OK);
    }
    
}
