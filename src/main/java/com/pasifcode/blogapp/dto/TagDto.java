package com.pasifcode.blogapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pasifcode.blogapp.model.Tag;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class TagDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String description;
    private String icon;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime lastModifiedDate;

    public TagDto() {
    }

    public TagDto(Tag tag) {
        id = tag.getId();
        title = tag.getTitle();
        description = tag.getDescription();
        icon = tag.getIcon();
        createdDate = tag.getCreatedDate();
        lastModifiedDate = tag.getLastModifiedDate();
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

    public String getIcon() {
        return icon;
    }
}
