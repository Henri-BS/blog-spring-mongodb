package com.pasifcode.blogapp.model;

import com.pasifcode.blogapp.dto.AuthorDto;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Comment extends BaseModel {

    private String body;
    private Post post;
    private AuthorDto author;

    public Comment() {
    }

    public Comment(String id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, String body, Post post, AuthorDto author) {
        super(id, createdDate, lastModifiedDate);
        this.body = body;
        this.post = post;
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
