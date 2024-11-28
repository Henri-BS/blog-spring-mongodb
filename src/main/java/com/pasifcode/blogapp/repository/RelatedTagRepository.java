package com.pasifcode.blogapp.repository;

import com.pasifcode.blogapp.model.RelatedTag;
import com.pasifcode.blogapp.model.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelatedTagRepository extends MongoRepository<RelatedTag, String> {

    List<RelatedTag> findByTag(Tag tag);
}
