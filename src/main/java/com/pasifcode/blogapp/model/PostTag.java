package com.pasifcode.blogapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PostTag {

    @Id
    private String id;
    private Post post;
    private Tag tag;

    public PostTag() {
    }

    public PostTag(String id, Post post, Tag tag) {
        this.id = id;
        this.post = post;
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
