package com.pasifcode.blogapp.service;

import com.pasifcode.blogapp.dto.CommentDto;
import com.pasifcode.blogapp.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> search(String body);

    Comment findById(String id);

    Comment saveComment(CommentDto dto);

    Comment updateComment(CommentDto dto);

    void deleteComment(String id);
}
