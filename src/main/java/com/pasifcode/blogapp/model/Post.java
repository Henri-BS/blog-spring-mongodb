package com.pasifcode.blogapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Post {

    @Id
    private String id;
    private String title;
    private String summary;
    private String image;
    private String description;
    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime lastModifiedDate = LocalDateTime.now();
    private User author;

    public Post() {
    }

    public Post(String id, String title, String summary, String image, String description, LocalDateTime createdDate, LocalDateTime lastModifiedDate, User author) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.image = image;
        this.description = description;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
