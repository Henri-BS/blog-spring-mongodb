package com.pasifcode.blogapp.service.impl;

import com.pasifcode.blogapp.dto.AuthorDto;
import com.pasifcode.blogapp.dto.PostDto;
import com.pasifcode.blogapp.model.Post;
import com.pasifcode.blogapp.model.User;
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
    public List<Post> search(String title) {
        return postRepository.findByTitleContaining(title);
    }

    @Override
    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Post savePost(PostDto dto) {
        User user = userRepository.findById(dto.getAuthor().getId()).orElseThrow();
        AuthorDto author = new AuthorDto(user);

        Post add = new Post();
        add.setTitle(dto.getTitle());
        add.setSummary(dto.getSummary());
        add.setDescription(dto.getDescription());
        add.setImage(dto.getImage());
        add.setAuthor(author);
        postRepository.save(add);

        user.getPosts().add(add);
        userRepository.save(user);

        return add;
    }

    @Override
    public Post updatePost(PostDto dto) {
        Post edit = postRepository.findById(dto.getId()).orElseThrow();

        edit.setId(edit.getId());
        edit.setTitle(dto.getTitle());
        edit.setSummary(dto.getSummary());
        edit.setDescription(dto.getDescription());
        edit.setImage(dto.getImage());

        if (dto.getTitle() == null )
            edit.setTitle(edit.getTitle());
        if(dto.getSummary() == null )
            edit.setSummary(edit.getSummary());
        if(dto.getDescription() == null)
            edit.setDescription(edit.getDescription());
        if(dto.getImage() == null)
            edit.setImage(edit.getImage());

       return postRepository.save(edit);

    }

    @Override
    public void deletePost(String id) {
        this.userRepository.deleteById(id);
    }
}
