package com.example.test_task.entity;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private List<LocationShare> locationShares;

    @ManyToMany(mappedBy = "locations")
    private List<User> users;

    public Location() {
    }

    public Location(Long id, String name, String address) {
        Id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LocationShare> getLocationShares() {
        return locationShares;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setLocationShares(List<LocationShare> locationShares) {
        this.locationShares = locationShares;
    }


    @Override
    public String toString() {
        return "Location{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
