package com.example.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Settlement extends PanacheEntity {

    public Integer last_mileage;
    public Integer new_mileage;

    @JsonbDateFormat("yyyy-MM-dd HH:mm")
    public LocalDateTime date;
    public Double km_price;

    public Settlement(Integer last_mileage, Integer new_mileage, LocalDateTime date, Double km_price) {
        this.last_mileage = last_mileage;
        this.new_mileage = new_mileage;
        this.date = date;
        this.km_price = km_price;
    }

    public Settlement() {
    }
}
