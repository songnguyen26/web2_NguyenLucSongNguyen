package com.example.NguyenLucSongNguyen.service.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.NguyenLucSongNguyen.domain.Cart;
import com.example.NguyenLucSongNguyen.domain.Role;
import com.example.NguyenLucSongNguyen.domain.User;
import com.example.NguyenLucSongNguyen.dto.RoleDTO;
import com.example.NguyenLucSongNguyen.dto.UserDTO;
import com.example.NguyenLucSongNguyen.dto.request.UserRequest;
import com.example.NguyenLucSongNguyen.dto.response.UserResponse;
import com.example.NguyenLucSongNguyen.repository.UserRepo;
import com.example.NguyenLucSongNguyen.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        
        try{
            User user = modelMapper.map(userDTO,User.class);
            Cart cart = new Cart();
            Role role = modelMapper.map(userDTO.getRole(),Role.class);
            cart.setUser(user);
            user.setCart(cart);
            user.setRole(role);
            User savedUser = userRepo.save(user);
            return modelMapper.map(savedUser,UserDTO.class);
        }catch(DataIntegrityViolationException e){
            throw new RuntimeException("User with email: " + userDTO.getEmail() + " has already existed" );
        }
        
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long userId) {
       User existedUser = userRepo.findById(userId).get();
       existedUser.setUserId(userId);
       existedUser.setEmail(userDTO.getEmail());
       existedUser.setAddress(userDTO.getAddress());
       existedUser.setFirstName(userDTO.getFirstName());
       existedUser.setLastName(userDTO.getLastName());
       existedUser.setPhoneNumber(userDTO.getPhoneNumber());
       existedUser.setRole(modelMapper.map(userDTO.getRole(),Role.class));
       User updatedUser = userRepo.save(existedUser);
       return modelMapper.map(updatedUser,UserDTO.class);
       
    }

    @Override
    public String deleteUserById(Long userId) {
       userRepo.deleteById(userId);
       return "User with userId "+ userId +"deleted successful";
    }


    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User with id: "+ userId+" not found"));
        return modelMapper.map(user,UserDTO.class);
    }

    @Override
    public UserResponse getALlUsers(Integer pageSize, Integer pageNumber, String sortBy, String sortOrder) {
        Sort sortByAndOrder = sortBy.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByAndOrder);
        Page<User> pageUsers = userRepo.findAll(pageDetails);
        List<User> users = pageUsers.getContent();
        List<UserDTO> userDTOs = users.stream().map(user -> modelMapper.map(user,UserDTO.class)).collect(Collectors.toList());
        UserResponse userResponse = new UserResponse();
        userResponse.setContent(userDTOs);
        userResponse.setPageNumber(pageUsers.getNumber());
        userResponse.setPageSize(pageUsers.getSize());
        userResponse.setTotalElements(pageUsers.getTotalElements());
        userResponse.setTotalPage(pageUsers.getTotalPages());
        userResponse.setLastPage(pageUsers.isLast());
        return userResponse;
    }
}
