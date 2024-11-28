package com.pasifcode.blogapp.service;

import com.pasifcode.blogapp.dto.PostTagDto;
import com.pasifcode.blogapp.model.Post;
import com.pasifcode.blogapp.model.PostTag;


import java.util.List;

public interface PostTagService {
    List<PostTag> findByPost(Post post);

    PostTag savePostTag(PostTagDto dto);

    void deletePostTag(String id);
}
