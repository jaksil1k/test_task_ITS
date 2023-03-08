package com.example.test_task.controller;

import com.example.test_task.entity.User;
import com.example.test_task.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAll();
    }
}
