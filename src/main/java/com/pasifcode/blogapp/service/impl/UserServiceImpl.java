package com.pasifcode.blogapp.service.impl;

import com.pasifcode.blogapp.dto.UserDto;
import com.pasifcode.blogapp.model.User;
import com.pasifcode.blogapp.repository.UserRepository;
import com.pasifcode.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User saveUser(UserDto dto) {
        User add = new User();

        add.setEmail(dto.getEmail());
        add.setUsername(dto.getUsername());
        add.setPassword(dto.getPassword());

        return userRepository.save(add);
    }

    @Override
    public User updateUser(UserDto dto) {
        User edit = userRepository.findById(dto.getId()).orElseThrow(NoSuchElementException::new);

        edit.setId(edit.getId());
        edit.setUsername(dto.getUsername());

        return userRepository.save(edit);
    }
}
