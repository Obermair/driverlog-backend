package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Driver extends PanacheEntity {

    public String firstname;
    public String lastname;
    public boolean leader;

    public Driver(String firstname, String lastname, boolean leader) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.leader = leader;
    }

    public Driver() {
    }
}
