package com.example.test_task.dto;

import com.example.test_task.entity.Location;

public class LocationShareDto {
    private String email;

    private Location location;
    private boolean couldShare;

    public LocationShareDto() {
    }

    public LocationShareDto(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getCouldShare() {
        return couldShare;
    }

    public void setCouldShare(boolean couldShare) {
        this.couldShare = couldShare;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isCouldShare() {
        return couldShare;
    }
}
