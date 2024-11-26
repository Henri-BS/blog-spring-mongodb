package com.pasifcode.blogapp.service;

import com.pasifcode.blogapp.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post findById(String id);
}
