package com.pasifcode.blogapp.controller;

import com.pasifcode.blogapp.dto.TagDto;
import com.pasifcode.blogapp.model.Tag;
import com.pasifcode.blogapp.service.TagService;
import com.pasifcode.blogapp.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    private ResponseEntity<List<TagDto>> searchTags(@RequestParam(defaultValue = "") String query){
        query = URL.decodeParams(query);
        List<Tag> list = tagService.search(query);
        return ResponseEntity.ok(list.stream().map(TagDto::new).toList());
    }

    @GetMapping("/{id}")
    private ResponseEntity<TagDto> findTagById(@PathVariable String id){
        Tag find = tagService.findById(id);
        return ResponseEntity.ok(new TagDto(find));
    }

    @PostMapping
    public ResponseEntity<Void> saveTag(@RequestBody TagDto dto) {
        TagDto tag = new TagDto(tagService.saveTag(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tag.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<TagDto> updateTag(@RequestBody TagDto dto) {
        TagDto tag = new TagDto(tagService.updateTag(dto));
        return ResponseEntity.ok(tag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable String id){
        this.tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }

}
