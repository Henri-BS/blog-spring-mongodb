package com.pasifcode.blogapp.service;

import com.pasifcode.blogapp.dto.RelatedTagDto;
import com.pasifcode.blogapp.model.RelatedTag;
import com.pasifcode.blogapp.model.Tag;

import java.util.List;

public interface RelatedTagService {
    List<RelatedTag> findByTag(Tag tag);

    RelatedTag saveRelatedTag(RelatedTagDto dto);

    void deleteRelatedTag(String id);
}
