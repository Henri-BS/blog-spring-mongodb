package com.pasifcode.blogapp.repository;

import com.pasifcode.blogapp.model.Post;
import com.pasifcode.blogapp.model.PostTag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostTagRepository extends MongoRepository<PostTag, String> {
    List<PostTag> findByPost(Post post);
}
