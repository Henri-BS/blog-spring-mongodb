package com.pasifcode.blogapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pasifcode.blogapp.model.Post;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class PostDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String description;
    private String summary;
    private String image;
    private String notes;
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
        description = post.getDescription();
        summary = post.getSummary();
        image = post.getImage();
        notes = post.getNotes();
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

    public String getDescription() {
        return description;
    }

    public String getSummary() {
        return summary;
    }

    public String getImage() {
        return image;
    }

    public String getNotes() {
        return notes;
    }

    public AuthorDto getAuthor() {
        return author;
    }


}
