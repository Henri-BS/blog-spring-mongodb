package com.pasifcode.blogapp.service;

import com.pasifcode.blogapp.dto.UserDto;
import com.pasifcode.blogapp.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(String id);

    User saveUser(UserDto dto);

    User updateUser(UserDto dto);

    void deleteUser(String id);
}
