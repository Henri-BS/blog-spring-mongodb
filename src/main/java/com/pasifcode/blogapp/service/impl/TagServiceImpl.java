package com.pasifcode.blogapp.service.impl;

import com.pasifcode.blogapp.dto.TagDto;
import com.pasifcode.blogapp.model.Tag;
import com.pasifcode.blogapp.repository.TagRepository;
import com.pasifcode.blogapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> search(String title) {
        return tagRepository.findByTitleContaining(title);
    }

    @Override
    public Tag findById(String id) {
        return tagRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Tag saveTag(TagDto dto) {

        Tag add = new Tag();
        add.setTitle(dto.getTitle());
        add.setDescription(dto.getDescription());
        add.setIcon(dto.getIcon());
        tagRepository.save(add);

        return add;
    }

    @Override
    public Tag updateTag(TagDto dto) {
        Tag edit = tagRepository.findById(dto.getId()).orElseThrow();

        edit.setId(edit.getId());
        edit.setTitle(dto.getTitle());
        edit.setDescription(dto.getDescription());
        edit.setIcon(dto.getIcon());

        if (dto.getTitle() == null )
            edit.setTitle(edit.getTitle());
        if(dto.getDescription() == null)
            edit.setDescription(edit.getDescription());
        if(dto.getIcon() == null)
            edit.setIcon(edit.getIcon());

       return tagRepository.save(edit);
    }

    @Override
    public void deleteTag(String id) {
        this.tagRepository.deleteById(id);
    }
}
