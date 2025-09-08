package com.spring_advanced.spring_advanced.service;

import com.spring_advanced.spring_advanced.entity.User;
import com.spring_advanced.spring_advanced.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
