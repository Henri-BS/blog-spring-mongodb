package com.pasifcode.blogapp.repository;

import com.pasifcode.blogapp.model.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends MongoRepository<Tag, String> {
    List<Tag> findByTitleContaining(String title);
}
