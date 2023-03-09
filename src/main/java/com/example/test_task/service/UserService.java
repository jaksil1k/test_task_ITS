package com.example.test_task.service;

import com.example.test_task.entity.User;
import com.example.test_task.entity.UserWithError;
import com.example.test_task.repositry.UserRepository;
import com.example.test_task.service.util.EmailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private static final String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public User create(User user) {
        if (!EmailValidation.patternMatches(user.getEmail(), regexPattern)) {
            return new UserWithError("incorrect email");
        }
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            return new UserWithError(e.getMessage());
        }
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getAllFriendsByUserId(Long user_id) {
        return userRepository.getAllFriendsByUserId(user_id);
    }
}
