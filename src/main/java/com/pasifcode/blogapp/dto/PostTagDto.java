package com.pasifcode.blogapp.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.pasifcode.blogapp.model.PostTag;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class PostTagDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private PostDto post;
    private TagDto tag;

    public PostTagDto() {
    }

    public PostTagDto(PostTag postTag) {
        id = postTag.getId();
        post = new PostDto(postTag.getPost());
        tag = new TagDto(postTag.getTag());
    }

    public String getId() {
        return id;
    }

    public PostDto getPost() {
        return post;
    }

    public TagDto getTag() {
        return tag;
    }
}
