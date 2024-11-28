package com.pasifcode.blogapp.service.impl;

import com.pasifcode.blogapp.dto.PostTagDto;
import com.pasifcode.blogapp.model.Post;
import com.pasifcode.blogapp.model.PostTag;
import com.pasifcode.blogapp.model.Tag;
import com.pasifcode.blogapp.repository.PostRepository;
import com.pasifcode.blogapp.repository.PostTagRepository;
import com.pasifcode.blogapp.repository.TagRepository;
import com.pasifcode.blogapp.service.PostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostTagServiceImpl implements PostTagService {

    @Autowired
    private PostTagRepository postTagRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<PostTag> findByPost(Post post) {
        return postTagRepository.findByPost(post);
    }

    @Override
    public PostTag savePostTag(PostTagDto dto) {
        Post post = postRepository.findById(dto.getPost().getId()).orElseThrow();
        Tag tag = tagRepository.findById(dto.getTag().getId()).orElseThrow();

        PostTag add = new PostTag();
        add.setPost(post);
        add.setTag(tag);
        postTagRepository.save(add);

        tag.getPostTags().add(add);
        tagRepository.save(tag);

        post.getPostTags().add(add);
        postRepository.save(post);

        return add;
    }

    @Override
    public void deletePostTag(String id) {
        this.postTagRepository.deleteById(id);
    }
}
