package com.pasifcode.blogapp.repository;

import com.pasifcode.blogapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <User, String> {

}
