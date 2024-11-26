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
    private LocalDateTime dateCreated;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dateUpdated;
    private AuthorDto author;

    public PostDto() {
    }

    public PostDto(Post post) {
        id = post.getId();
        title = post.getTitle();
        summary = post.getSummary();
        image = post.getImage();
        description = post.getDescription();
        dateCreated = post.getCreatedDate();
        dateUpdated = post.getLastModifiedDate();
        author = new AuthorDto(post.getAuthor());
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public AuthorDto getAuthor() {
        return author;
    }
}
