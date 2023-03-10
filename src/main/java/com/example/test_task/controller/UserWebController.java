package com.example.test_task.controller;

import com.example.test_task.entity.Location;
import com.example.test_task.entity.User;
import com.example.test_task.service.LocationService;
import com.example.test_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserWebController {
    @Autowired
    private UserService userService;
    @Autowired
    private LocationService locationService;

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }
    @PostMapping("/create")
    public String createUserPost(@ModelAttribute User user, Model model) throws Exception {
        user = userService.create(user);
        return "redirect:/users/" + user.getEmail();
    }

    @GetMapping("/{email}")
    public String getUserById(@PathVariable String email, Model model) {
        Optional<User> optionalUser = userService.getByEmail(email);
        if (optionalUser.isEmpty()) {
            return "user-not-found";
        }
        model.addAttribute("user", optionalUser.get());
        return "show-user";
    }

    @GetMapping("/all-available")
    public String getAllAvailableLocations(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Location> locations = locationService.getAllLocationsByUserEmail(user.getEmail());

        model.addAttribute("locations", locations);
        return "show-all-user-locations";
    }
}
