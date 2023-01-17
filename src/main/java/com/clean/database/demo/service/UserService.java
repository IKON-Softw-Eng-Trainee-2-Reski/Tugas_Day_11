package com.clean.database.demo.service;
import com.clean.database.demo.entity.User;
import com.clean.database.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired(required = false)
    UserRepository userRepository;

    public List<User> getUser() {
        return (List<User>) userRepository.findAll();
    }

    public User addUser(User addedUser) {
        long size = userRepository.count();
        log.info("[user] REPOSITORY SIZE IS: " + size);
        Integer newId = (int) size + 1;
        log.info("[user] newId IS: " + newId);
        User user = new User(newId, addedUser.getEmail(), addedUser.getPassword());

        userRepository.save(user);
        log.info("[user] newly added user in repository is: " + userRepository.findById(newId).get());
        return userRepository.findById(newId).get();
    }
}
