package com.example.test_task.service;

import com.example.test_task.entity.Location;
import com.example.test_task.entity.User;
import com.example.test_task.repositry.LocationRepository;
import com.example.test_task.repositry.LocationShareRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationShareRepository locationShareRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository, LocationShareRepository locationShareRepository) {
        this.locationRepository = locationRepository;
        this.locationShareRepository = locationShareRepository;
    }

    public Location create(Location location) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User)authentication.getPrincipal();

        location = locationRepository.save(location);

        currentUser.addLocationToUser(location);
        return location;
    }

    public Optional<Location> getById(Long id) {
        return locationRepository.findById(id);
    }
}
