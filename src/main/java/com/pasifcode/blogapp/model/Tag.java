package com.pasifcode.blogapp.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
public class Tag extends BaseModel {

    private String icon;
    @DBRef(lazy = true)
    private List<PostTag> postTags = new ArrayList<>();
    @DBRef(lazy = true)
    private List<RelatedTag> relatedTags = new ArrayList<>();

    public Tag() {
    }

    public Tag(String id, String title, String description, String icon, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        super(id, title, description, createdDate, lastModifiedDate);
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<PostTag> getPostTags() {
        return postTags;
    }

    public List<RelatedTag> getRelatedTags() {
        return relatedTags;
    }
}
