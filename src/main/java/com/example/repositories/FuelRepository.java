package com.example.repositories;

import com.example.entities.Fuel;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class FuelRepository implements PanacheRepository<Fuel> {

    @Transactional
    public void update(Fuel fuel){
        Panache.getEntityManager().merge(fuel);
    }
}
