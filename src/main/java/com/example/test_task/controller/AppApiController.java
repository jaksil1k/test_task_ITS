package com.example.test_task.controller;

import com.example.test_task.dto.LocationDto;
import com.example.test_task.dto.LocationShareDto;
import com.example.test_task.dto.UserDto;
import com.example.test_task.entity.Location;
import com.example.test_task.entity.LocationShare;
import com.example.test_task.entity.User;
import com.example.test_task.mapper.LocationMapper;
import com.example.test_task.mapper.LocationShareMapper;
import com.example.test_task.mapper.UserMapper;
import com.example.test_task.repositry.LocationShareRepository;
import com.example.test_task.service.LocationService;
import com.example.test_task.service.LocationShareService;
import com.example.test_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AppApiController {

    private final LocationService locationService;
    private final UserService userService;

    private final LocationShareService locationShareService;

    @Autowired
    public AppApiController(LocationService locationService, UserService userService, LocationShareRepository locationShareRepository, LocationShareService locationShareService) {
        this.locationService = locationService;
        this.userService = userService;
        this.locationShareService = locationShareService;
    }
    @PostMapping("/locations/create")
    public Location createLocationPost(@RequestBody Location location) throws Exception {
        return locationService.create(location);
    }
    @GetMapping("/locations/all-friends/{id}")
    public List<UserDto> getAllFriendsOnLocationById(@PathVariable Long id) {
        return UserMapper.MAPPER.toDto(userService.getAllFriendUsersOnLocation(id));
    }

    @PostMapping("/locations/share")
    public LocationShareDto shareLocation(@RequestBody LocationShareDto locationShareDto) {
        Optional<User> user = userService.getByEmail(locationShareDto.getEmail());
        if (user.isEmpty()) {
            throw new RuntimeException("user not found");
        }
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
//        System.out.println(currentUser);
        LocationShare locationShare = new LocationShare(user.get(),
                locationService.getById(locationShareDto.getLocationId()).get(), currentUser, locationShareDto.getCouldShare());
        LocationShareDto shareDto = LocationShareMapper.MAPPER.toDto(locationShareService.create(locationShare));
        shareDto.setEmail(locationShare.getUser().getEmail());
        shareDto.setLocationId(locationShare.getLocation().getId());
        shareDto.setSharedUserEmail(locationShareDto.getSharedUserEmail());
        return shareDto;
    }

    @GetMapping("/users/all-available-locations")
    public List<LocationDto> getAllAvailableLocations() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return LocationMapper.MAPPER.toDto(locationService.getAllLocationsByUserEmail(user.getEmail()));
    }



}
