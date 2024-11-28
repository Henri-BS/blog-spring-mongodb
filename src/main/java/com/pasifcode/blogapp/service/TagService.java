package com.pasifcode.blogapp.service;

import com.pasifcode.blogapp.dto.TagDto;
import com.pasifcode.blogapp.model.Tag;

import java.util.List;

public interface TagService {
    List<Tag> search(String query);

    Tag findById(String id);

    Tag saveTag(TagDto dto);

    Tag updateTag(TagDto dto);

    void deleteTag(String id);
}
