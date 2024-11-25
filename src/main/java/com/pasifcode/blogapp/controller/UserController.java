package com.pasifcode.blogapp.controller;

import com.pasifcode.blogapp.model.User;
import com.pasifcode.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private List<User> findAllUsers(){
        List<User> list = userService.findAll();
        return list;
    }
}
