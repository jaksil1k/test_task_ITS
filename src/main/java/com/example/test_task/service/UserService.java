package com.example.test_task.service;

import com.example.test_task.entity.User;
import com.example.test_task.repositry.UserRepository;
import com.example.test_task.service.util.EmailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        if (!EmailValidation.patternMatches(user.getEmail())) {
            throw new RuntimeException("Invalid email");
        }

        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> optionalUser = getByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        return optionalUser.get();
    }

    public Optional<User> getByEmail(String email) {
        return repository.findByEmail(email);
    }


    public List<User> getAllFriendUsersOnLocation(Long location_id) {
        String user_email = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository.getAllFriendsByLocationId(location_id, user_email);
    }
}
