package com.example.test_task.controller;

import com.example.test_task.entity.User;
import com.example.test_task.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) throws Exception {
        return userService.create(user);
    }
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/friends/{id}")
    public List<User> getAllFriendsByUserId(@PathVariable Long id) {
        return userService.getAllFriendsByUserId(id);
    }
}
