package com.example.test_task.service;

import com.example.test_task.entity.Location;
import com.example.test_task.entity.User;
import com.example.test_task.entity.UserWithError;
import com.example.test_task.repositry.UserRepository;
import com.example.test_task.service.util.EmailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    private static final String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public User create(User user) throws Exception {
        if (!EmailValidation.patternMatches(user.getEmail(), regexPattern)) {
            return new UserWithError("incorrect email");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println((User)authentication.getPrincipal());
        try {
            return repository.save(user);
        } catch (Exception e) {
            throw new Exception("invalid Email");
        }
    }

    public Iterable<User> getAll() {
        return repository.findAll();
    }

    public List<User> getAllFriendsByUserId(Long user_id) {
        return repository.getAllFriendsByUserId(user_id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> optionalUser = repository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        return optionalUser.get();
    }

    public Optional<User> getById (Long id) {
        return repository.findById(id);
    }

    public Optional<User> getByEmail(String email) {
        return repository.findByEmail(email);
    }


}
