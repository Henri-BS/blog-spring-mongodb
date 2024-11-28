package com.pasifcode.blogapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RelatedTag {

    @Id
    private String id;
    private Tag tagFrom;
    private Tag tagTo;

    public RelatedTag() {
    }

    public RelatedTag(String id, Tag tagFrom, Tag tagTo) {
        this.id = id;
        this.tagFrom = tagFrom;
        this.tagTo = tagTo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tag getTagFrom() {
        return tagFrom;
    }

    public void setTagFrom(Tag tagFrom) {
        this.tagFrom = tagFrom;
    }

    public Tag getTagTo() {
        return tagTo;
    }

    public void setTagTo(Tag tagTo) {
        this.tagTo = tagTo;
    }
}
