package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Ride extends PanacheEntity {

    @ManyToOne
    public Driver driver;

    @JsonbDateFormat("yyyy-MM-dd HH:mm")
    public LocalDateTime date;
    public Integer km;
    public String description;

    public Ride(Driver driver, LocalDateTime date, Integer km, String description) {
        this.driver = driver;
        this.date = date;
        this.km = km;
        this.description = description;
    }

    public Ride() {
    }
}
