package com.pasifcode.blogapp.controller;

import com.pasifcode.blogapp.dto.RelatedTagDto;
import com.pasifcode.blogapp.model.RelatedTag;
import com.pasifcode.blogapp.model.Tag;
import com.pasifcode.blogapp.service.RelatedTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/related-tag")
public class RelatedTagController {

    @Autowired
    private RelatedTagService relatedTagService;

    @GetMapping
    private ResponseEntity<List<RelatedTagDto>> findByTag(Tag tag){
        List<RelatedTag> list = relatedTagService.findByTag(tag);
        return ResponseEntity.ok(list.stream().map(RelatedTagDto::new).toList());
    }

    @PostMapping
    public ResponseEntity<Void> saveTagRelated(@RequestBody RelatedTagDto dto) {
        RelatedTagDto tag = new RelatedTagDto(relatedTagService.saveRelatedTag(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tag.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTagRelated(@PathVariable String id){
        this.relatedTagService.deleteRelatedTag(id);
        return ResponseEntity.noContent().build();
    }

}
