package com.pasifcode.blogapp.model;

import com.pasifcode.blogapp.dto.AuthorDto;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
public class Post extends BaseModel {

    private String image;
    private String summary;
    private String notes;
    private AuthorDto author;
    @DBRef(lazy = true)
    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String id, String title, String description, String image, LocalDateTime createdDate, LocalDateTime lastModifiedDate, String summary, String notes, AuthorDto author) {
        super(id, title, description, createdDate, lastModifiedDate);
        this.image = image;
        this.summary = summary;
        this.notes = notes;
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
