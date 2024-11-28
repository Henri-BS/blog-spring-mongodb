package com.pasifcode.blogapp.service.impl;

import com.pasifcode.blogapp.dto.RelatedTagDto;
import com.pasifcode.blogapp.model.RelatedTag;
import com.pasifcode.blogapp.model.Tag;
import com.pasifcode.blogapp.repository.RelatedTagRepository;
import com.pasifcode.blogapp.repository.TagRepository;
import com.pasifcode.blogapp.service.RelatedTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatedTagServiceImpl implements RelatedTagService {

    @Autowired
    private RelatedTagRepository relatedTagRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<RelatedTag> findByTag(Tag tag) {
        return relatedTagRepository.findByTag(tag);
    }

    @Override
    public RelatedTag saveRelatedTag(RelatedTagDto dto) {
        Tag tagFrom = tagRepository.findById(dto.getTagFrom().getId()).orElseThrow();
        Tag tagTo = tagRepository.findById(dto.getTagTo().getId()).orElseThrow();

        RelatedTag add = new RelatedTag();
        add.setTagFrom(tagFrom);
        add.setTagTo(tagTo);
        relatedTagRepository.save(add);

        tagFrom.getRelatedTags().add(add);
        tagRepository.save(tagFrom);

        tagTo.getRelatedTags().add(add);
        tagRepository.save(tagTo);

        return add;
    }

    @Override
    public void deleteRelatedTag(String id) {
        this.relatedTagRepository.deleteById(id);
    }
}
