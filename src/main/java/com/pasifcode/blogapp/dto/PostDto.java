package com.pasifcode.blogapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pasifcode.blogapp.model.Post;

import java.time.LocalDateTime;

public class PostDto {
    private String id;
    private String title;
    private String summary;
    private String image;
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime lastModifiedDate;
    private AuthorDto author;

    public PostDto() {
    }

    public PostDto(Post post) {
        id = post.getId();
        title = post.getTitle();
        summary = post.getSummary();
        image = post.getImage();
        description = post.getDescription();
        createdDate = post.getCreatedDate();
        lastModifiedDate = post.getLastModifiedDate();
        author = post.getAuthor();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public AuthorDto getAuthor() {
        return author;
    }
}
