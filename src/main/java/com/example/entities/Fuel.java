package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Fuel extends PanacheEntity {

    @ManyToOne
    public Driver driver;

    @JsonbDateFormat("yyyy-MM-dd HH:mm")
    public LocalDateTime date;
    public Double price;

    public Fuel(Driver driver, LocalDateTime date, Double price) {
        this.driver = driver;
        this.date = date;
        this.price = price;
    }

    public Fuel() {
    }
}
