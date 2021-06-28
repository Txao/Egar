package com.example.testhub.service;

import com.example.testhub.domain.User;
import com.example.testhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public User deleteByUsername(String username) {
        return this.userRepository.deleteByUsername(username);
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }
}
