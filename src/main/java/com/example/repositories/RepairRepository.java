package com.example.repositories;

import com.example.entities.Repair;
import com.example.entities.Ride;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class RepairRepository implements PanacheRepository<Repair> {

    @Transactional
    public void update(Repair repair){
        Panache.getEntityManager().merge(repair);
    }
}
