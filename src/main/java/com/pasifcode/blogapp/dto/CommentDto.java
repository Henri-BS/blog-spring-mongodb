package com.pasifcode.blogapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pasifcode.blogapp.model.Comment;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class CommentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String body;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime lastModifiedDate;
    private PostDto post;
    private AuthorDto author;

    public CommentDto() {
    }

    public CommentDto(Comment comment) {
        id = comment.getId();
        body = comment.getBody();
        createdDate = comment.getCreatedDate();
        lastModifiedDate = comment.getLastModifiedDate();
        post = new PostDto(comment.getPost());
        author = comment.getAuthor();
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public PostDto getPost() {
        return post;
    }

    public AuthorDto getAuthor() {
        return author;
    }
}
