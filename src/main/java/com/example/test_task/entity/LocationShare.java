package com.example.test_task.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shared_locations")
public class LocationShare {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

//    @Column(name = "user_id")
//    private Long user_id;
//
//    @Column(name = "location_id")
//    private Long location_id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_email")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    private User sharedUser;

    @Column(name = "could_share")
    private boolean couldShare;

    public LocationShare() {
    }

    public LocationShare(User user, Location location, User sharedUser, boolean couldShare) {
        this.user = user;
        this.location = location;
        this.sharedUser = sharedUser;
        this.couldShare = couldShare;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean getCouldShare() {
        return couldShare;
    }

    public void setCouldShare(boolean couldShare) {
        this.couldShare = couldShare;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSharedUser() {
        return sharedUser;
    }

    public void setSharedUser(User sharedUser) {
        this.sharedUser = sharedUser;
    }

    public boolean isCouldShare() {
        return couldShare;
    }

    @Override
    public String toString() {
        return "LocationShare{" +
                "id=" + id +
                ", user=" + user +
                ", location=" + location +
                ", sharedUser=" + sharedUser +
                ", couldShare=" + couldShare +
                '}';
    }
}
