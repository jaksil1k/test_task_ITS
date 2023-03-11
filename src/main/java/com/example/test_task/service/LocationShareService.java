package com.example.test_task.service;

import com.example.test_task.entity.LocationShare;
import com.example.test_task.repositry.LocationShareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationShareService {
    @Autowired
    private LocationShareRepository locationShareRepository;


    public LocationShare create(LocationShare locationShare) {
        System.out.println(locationShare);
        return locationShareRepository.save(locationShare);
    }
}
