package com.example.test_task.controller;

import com.example.test_task.entity.User;
import com.example.test_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserWebController {
    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }
    @PostMapping("/create")
    public String createUserPost(@ModelAttribute User user, Model model) {
        model.addAttribute("user", userService.create(user));
        return "created-user";
    }
}
