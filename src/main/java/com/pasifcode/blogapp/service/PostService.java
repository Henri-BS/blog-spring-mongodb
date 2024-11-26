package com.pasifcode.blogapp.service;

import com.pasifcode.blogapp.dto.PostDto;
import com.pasifcode.blogapp.model.Post;

import java.util.List;

public interface PostService {
    List<Post> search(String title);

    Post findById(String id);

    Post savePost(PostDto dto);

    Post updatePost(PostDto dto);

    void deletePost(String id);
}
