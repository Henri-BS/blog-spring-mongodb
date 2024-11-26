package com.pasifcode.blogapp.controller;

import com.pasifcode.blogapp.dto.UserDto;
import com.pasifcode.blogapp.model.User;
import com.pasifcode.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto dto) {
        User add = userService.saveUser(dto);
        return new ResponseEntity<>(new UserDto(add), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto) {
        User edit = userService.updateUser(dto);
        return new ResponseEntity<>(new UserDto(edit),  HttpStatus.OK);
    }
}
