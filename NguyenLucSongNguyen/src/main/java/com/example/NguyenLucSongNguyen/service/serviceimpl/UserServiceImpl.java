package com.example.NguyenLucSongNguyen.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.NguyenLucSongNguyen.domain.User;
import com.example.NguyenLucSongNguyen.dto.request.UserRequest;
import com.example.NguyenLucSongNguyen.repository.UserRepo;
import com.example.NguyenLucSongNguyen.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user, Long userId) {
       User existedUser = userRepo.findById(userId).get();
       existedUser.setUserId(userId);
       existedUser.setEmail(user.getEmail());
       existedUser.setAddress(user.getAddress());
       existedUser.setFirstName(user.getFirstName());
       existedUser.setLastName(user.getLastName());
       existedUser.setPhoneNumber(user.getPhoneNumber());
    //    user.setRole(existedUser.getRole());
       return userRepo.save(existedUser);
       
    }

    @Override
    public String deleteUserById(Long userId) {
       userRepo.deleteById(userId);
       return "User with userId "+ userId +"deleted successful";
    }

    @Override
    public Page<User> getALlUsers(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepo.findById(userId).get();
    }
    
}
