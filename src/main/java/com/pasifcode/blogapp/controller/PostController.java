package com.pasifcode.blogapp.controller;

import com.pasifcode.blogapp.dto.PostDto;
import com.pasifcode.blogapp.dto.UserDto;
import com.pasifcode.blogapp.model.Post;
import com.pasifcode.blogapp.model.User;
import com.pasifcode.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    private ResponseEntity<List<PostDto>> findAllPosts(){
        List<Post> list = postService.findAll();
        return ResponseEntity.ok(list.stream().map(PostDto::new).toList());
    }

    @GetMapping("/{id}")
    private ResponseEntity<PostDto> findPostById(@PathVariable String id){
        Post find = postService.findById(id);
        return ResponseEntity.ok(new PostDto(find));
    }



}
