package com.example.test_task.service;

import com.example.test_task.entity.Location;
import com.example.test_task.entity.User;
import com.example.test_task.repositry.LocationRepository;
import com.example.test_task.repositry.LocationShareRepository;
import com.example.test_task.service.util.EmailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location create(Location location) throws Exception {
        if (location == null) {
            throw new NullPointerException();
        }

        if (location.getName().isBlank() || location.getAddress().isBlank()
                || location.getName() == null || location.getAddress() == null) {
            throw new Exception("name or address is blank");
        }

        var authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User)authentication.getPrincipal();

        location.setId(locationRepository.save(location).getId());

        currentUser.addLocationToUser(location);
        return location;
    }

    public List<Location> getAllLocationsByUserEmail(String email) {
        if (email == null || !EmailValidation.patternMatches(email)) {
            throw new RuntimeException("Email us invalid");
        }
        return locationRepository.getAllLocationsByUserEmail(email);
    }

    public Optional<Location> getById(Long id) {
        if (id == null || id < 1) {
            throw new RuntimeException("invalid id");
        }
        return locationRepository.findById(id);
    }
}
