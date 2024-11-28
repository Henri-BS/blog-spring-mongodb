package com.pasifcode.blogapp.service.impl;

import com.pasifcode.blogapp.dto.AuthorDto;
import com.pasifcode.blogapp.dto.CommentDto;
import com.pasifcode.blogapp.model.Comment;
import com.pasifcode.blogapp.model.Post;
import com.pasifcode.blogapp.model.User;
import com.pasifcode.blogapp.repository.CommentRepository;
import com.pasifcode.blogapp.repository.PostRepository;
import com.pasifcode.blogapp.repository.UserRepository;
import com.pasifcode.blogapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Comment> search(String body) {
        return commentRepository.findByBodyContaining(body);
    }

    @Override
    public Comment findById(String id) {
        return commentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Comment saveComment(CommentDto dto) {
        Post post = postRepository.findById(dto.getPost().getId()).orElseThrow();
        User user = userRepository.findById(dto.getAuthor().getId()).orElseThrow();
        AuthorDto author = new AuthorDto(user);

        Comment add = new Comment();
        add.setBody(dto.getBody());
        add.setAuthor(author);
        add.setPost(post);
        commentRepository.save(add);

        post.getComments().add(add);
        postRepository.save(post);
        user.getComments().add(add);
        userRepository.save(user);


        return add;
    }

    @Override
    public Comment updateComment(CommentDto dto) {
        Comment edit = commentRepository.findById(dto.getId()).orElseThrow();

        edit.setId(edit.getId());
        edit.setBody(dto.getBody());
        if (dto.getBody() == null)
            edit.setBody(edit.getBody());

        return commentRepository.save(edit);
    }

    @Override
    public void deleteComment(String id) {
        this.commentRepository.deleteById(id);
    }
}
