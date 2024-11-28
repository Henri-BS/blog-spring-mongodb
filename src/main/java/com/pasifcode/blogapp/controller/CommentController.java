package com.pasifcode.blogapp.controller;

import com.pasifcode.blogapp.dto.CommentDto;
import com.pasifcode.blogapp.model.Comment;
import com.pasifcode.blogapp.service.CommentService;
import com.pasifcode.blogapp.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    private ResponseEntity<List<CommentDto>> searchComments(@RequestParam(defaultValue = "") String query){
        query = URL.decodeParams(query);
        List<Comment> list = commentService.search(query);
        return ResponseEntity.ok(list.stream().map(CommentDto::new).toList());
    }

    @GetMapping("/{id}")
    private ResponseEntity<CommentDto> findCommentById(@PathVariable String id){
        Comment find = commentService.findById(id);
        return ResponseEntity.ok(new CommentDto(find));
    }

    @PostMapping
    public ResponseEntity<Void> saveComment(@RequestBody CommentDto dto) {
        CommentDto post = new CommentDto(commentService.saveComment(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto dto) {
        CommentDto post = new CommentDto(commentService.updateComment(dto));
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable String id){
        this.commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

}
