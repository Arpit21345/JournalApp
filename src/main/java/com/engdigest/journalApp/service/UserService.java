package com.engdigest.journalApp.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.engdigest.journalApp.entity.User;
import com.engdigest.journalApp.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository repository;

    

    public void saveEntry(User user) {
      
        repository.save(user);

    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return repository.findById(id);
    }

    public void deleteById(ObjectId id) {
        repository.deleteById(id);
    }

    public User findByUserName (String userName){
        return repository.findByUserName(userName);
    }
}
// controller call - --->service  calls --->repositriy
