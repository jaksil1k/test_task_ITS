package com.example.test_task.dto;

public class    LocationShareDto {

    private Long id;
    private String email;

    private Long locationId;

    private String sharedUserEmail;

    private boolean couldShare;

    public LocationShareDto() {
    }

    public LocationShareDto(Long location) {
        this.locationId = location;
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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public boolean isCouldShare() {
        return couldShare;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSharedUserEmail() {
        return sharedUserEmail;
    }

    public void setSharedUserEmail(String sharedUserEmail) {
        this.sharedUserEmail = sharedUserEmail;
    }

    @Override
    public String toString() {
        return "LocationShareDto{" +
                "email='" + email + '\'' +
                ", locationId=" + locationId +
                ", sharedUserEmail='" + sharedUserEmail + '\'' +
                ", couldShare=" + couldShare +
                '}';
    }
}
