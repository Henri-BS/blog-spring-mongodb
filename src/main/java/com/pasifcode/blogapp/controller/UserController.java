package com.pasifcode.blogapp.controller;

import com.pasifcode.blogapp.dto.UserDto;
import com.pasifcode.blogapp.model.User;
import com.pasifcode.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody UserDto dto) {
        UserDto user = new UserDto(userService.saveUser(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto) {
        User edit = userService.updateUser(dto);

        return new ResponseEntity<>(new UserDto(edit),  HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
