package com.example.test_task.entity;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @ManyToMany(mappedBy = "locations")
    private List<User> users;

    public Location() {
    }

    public Location(Long id, String name, String address, List<User> users) {
        Id = id;
        this.name = name;
        this.address = address;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
