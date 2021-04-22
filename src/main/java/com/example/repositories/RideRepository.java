package com.example.repositories;

import com.example.entities.Ride;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class RideRepository implements PanacheRepository<Ride> {
    @Transactional
    public void update(Ride ride){
        Panache.getEntityManager().merge(ride);
    }
}
