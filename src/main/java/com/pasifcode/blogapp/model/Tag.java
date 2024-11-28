package com.pasifcode.blogapp.model;

import com.pasifcode.blogapp.dto.AuthorDto;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
public class Tag extends BaseModel {

    private String icon;
    private AuthorDto author;
    @DBRef(lazy = true)
    private List<PostTag> comments = new ArrayList<>();
    @DBRef(lazy = true)
    private List<TagRelated> tags = new ArrayList<>();

    public Tag() {
    }

    public Tag(String id, String title, String description, String icon, LocalDateTime createdDate, LocalDateTime lastModifiedDate, AuthorDto author) {
        super(id, title, description, createdDate, lastModifiedDate);
        this.icon = icon;
        this.author = author;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

}
