package com.pasifcode.blogapp.controller;

import com.pasifcode.blogapp.dto.PostTagDto;
import com.pasifcode.blogapp.model.Post;
import com.pasifcode.blogapp.model.PostTag;
import com.pasifcode.blogapp.service.PostTagService;
import com.pasifcode.blogapp.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/post-tag")
public class PostTagController {

    @Autowired
    private PostTagService tagService;

    @GetMapping
    private ResponseEntity<List<PostTagDto>> findByPost(Post post){
        List<PostTag> list = tagService.findByPost(post);
        return ResponseEntity.ok(list.stream().map(PostTagDto::new).toList());
    }

    @PostMapping
    public ResponseEntity<Void> savePostTag(@RequestBody PostTagDto dto) {
        PostTagDto tag = new PostTagDto(tagService.savePostTag(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tag.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostTag(@PathVariable String id){
        this.tagService.deletePostTag(id);
        return ResponseEntity.noContent().build();
    }

}
