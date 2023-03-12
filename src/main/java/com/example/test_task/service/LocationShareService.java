package com.example.test_task.service;

import com.example.test_task.entity.LocationShare;
import com.example.test_task.repositry.LocationShareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LocationShareService {
    private final LocationShareRepository locationShareRepository;

    @Autowired
    public LocationShareService(LocationShareRepository locationShareRepository) {
        this.locationShareRepository = locationShareRepository;
    }

    public LocationShare create(LocationShare locationShare) {
        if (locationShare.getLocation() == null || locationShare.getUser() == null) {
            throw new RuntimeException("location or user is null");
        }
        if (Objects.equals(locationShare.getSharedUser(), locationShare.getUser().getEmail())) {
            throw new RuntimeException("user can not share with himself");
        }
//        if (!locationShare.getSharedUser().getLocations().contains(locationShare.getLocation())) {
//            throw new RuntimeException("this location doesn't belong to sharedUser");
//        }
        return locationShareRepository.save(locationShare);
    }
}
