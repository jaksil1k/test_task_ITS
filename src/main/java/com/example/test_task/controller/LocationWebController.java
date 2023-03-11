package com.example.test_task.controller;

import com.example.test_task.dto.LocationShareDto;
import com.example.test_task.entity.Location;
import com.example.test_task.entity.LocationShare;
import com.example.test_task.entity.User;
import com.example.test_task.repositry.LocationShareRepository;
import com.example.test_task.service.LocationService;
import com.example.test_task.service.LocationShareService;
import com.example.test_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/locations")
public class LocationWebController {

    private final LocationService locationService;
    private final UserService userService;

    private final LocationShareService locationShareService;
    @Autowired
    public LocationWebController(LocationService locationService, UserService userService, LocationShareRepository locationShareRepository, LocationShareService locationShareService) {
        this.locationService = locationService;
        this.userService = userService;
        this.locationShareService = locationShareService;
    }

    @GetMapping("/create")
    public String createLocation(Model model) {
        model.addAttribute("location", new Location());
        return "create-location";
    }
    @PostMapping("/create")
    public String createLocationPost(@ModelAttribute Location location, Model model) {
        location = locationService.create(location);
        return "redirect:/locations/" + location.getId();
    }
    @GetMapping("/{id}")
    public String getLocationById(@PathVariable Long id, Model model) {
        Optional<Location> optionalLocation = locationService.getById(id);
        if (optionalLocation.isEmpty()) {
            return "location-not-found";
        }
        model.addAttribute("location", optionalLocation.get());
        model.addAttribute("locationShareDto", new LocationShareDto(optionalLocation.get()));
        return "show-location";
    }

    @PostMapping("/share")
    public String shareLocation(@ModelAttribute LocationShareDto locationShareDto) {
        Optional<User> user = userService.getByEmail(locationShareDto.getEmail());
        if (user.isEmpty()) {
            return "can't find user by email" + locationShareDto.getEmail();
        }
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
//        System.out.println(currentUser);
        LocationShare locationShare = new LocationShare(user.get(), locationShareDto.getLocation(), currentUser, locationShareDto.getCouldShare());
        System.out.println(locationShare.getSharedUser());
        locationShareService.create(locationShare);
        return "redirect:/locations/" + locationShareDto.getLocation().getId();
    }
}
