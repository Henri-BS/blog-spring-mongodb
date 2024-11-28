package com.pasifcode.blogapp.controller;

import com.pasifcode.blogapp.dto.PostDto;
import com.pasifcode.blogapp.model.Post;
import com.pasifcode.blogapp.service.PostService;
import com.pasifcode.blogapp.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    private ResponseEntity<List<PostDto>> searchPosts(@RequestParam(defaultValue = "") String query){
        query = URL.decodeParams(query);
        List<Post> list = postService.search(query);
        return ResponseEntity.ok(list.stream().map(PostDto::new).toList());
    }

    @GetMapping("/{id}")
    private ResponseEntity<PostDto> findPostById(@PathVariable String id){
        Post find = postService.findById(id);
        return ResponseEntity.ok(new PostDto(find));
    }

    @PostMapping
    public ResponseEntity<Void> savePost(@RequestBody PostDto dto) {
        PostDto post = new PostDto(postService.savePost(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto dto) {
        PostDto post = new PostDto(postService.updatePost(dto));
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable String id){
        this.postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

}
