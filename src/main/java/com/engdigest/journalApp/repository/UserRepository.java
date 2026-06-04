package com.engdigest.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.engdigest.journalApp.entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId>{
    
    User findByUserName(String username);
}
