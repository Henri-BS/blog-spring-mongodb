package com.pasifcode.blogapp.service.impl;

import com.pasifcode.blogapp.model.Post;
import com.pasifcode.blogapp.repository.PostRepository;
import com.pasifcode.blogapp.repository.UserRepository;
import com.pasifcode.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
