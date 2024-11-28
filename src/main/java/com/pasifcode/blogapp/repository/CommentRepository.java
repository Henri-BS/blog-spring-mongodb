package com.pasifcode.blogapp.repository;

import com.pasifcode.blogapp.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByBodyContaining(String body);
}
