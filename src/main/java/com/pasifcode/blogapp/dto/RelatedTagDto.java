package com.pasifcode.blogapp.dto;

import com.pasifcode.blogapp.model.RelatedTag;

import java.io.Serial;
import java.io.Serializable;

public class RelatedTagDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private TagDto tagFrom;
    private TagDto tagTo;

    public RelatedTagDto() {
    }

    public RelatedTagDto(RelatedTag relatedTag) {
        id = relatedTag.getId();
        tagFrom = new TagDto(relatedTag.getTagFrom());
        tagTo = new TagDto(relatedTag.getTagTo());
    }

    public String getId() {
        return id;
    }

    public TagDto getTagFrom() {
        return tagFrom;
    }

    public TagDto getTagTo() {
        return tagTo;
    }
}
