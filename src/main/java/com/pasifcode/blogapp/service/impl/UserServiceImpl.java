package com.pasifcode.blogapp.service.impl;

import com.pasifcode.blogapp.model.User;
import com.pasifcode.blogapp.repository.UserRepository;
import com.pasifcode.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
