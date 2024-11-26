package com.pasifcode.blogapp.controller;

import com.pasifcode.blogapp.dto.UserDto;
import com.pasifcode.blogapp.model.User;
import com.pasifcode.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private ResponseEntity<List<UserDto>> findAllUsers(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok(list.stream().map(UserDto::new).toList());
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserDto> findUserById(@PathVariable String id){
        User find = userService.findById(id);
        return ResponseEntity.ok(new UserDto(find));
    }
}
