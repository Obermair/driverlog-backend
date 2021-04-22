package com.example.repositories;

import com.example.entities.Driver;
import com.example.entities.Ride;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DriverRepository implements PanacheRepository<Driver> {

    @Transactional
    public void update(Driver driver){
        Panache.getEntityManager().merge(driver);
    }

    public Object drivenKilometers(Long driver_id) {

        Query query = Panache.getEntityManager().createQuery("SELECT sum(km) FROM Ride " +
                "where driver_id = :driver_id");


        query.setParameter("driver_id", driver_id);
        return query.getSingleResult();
    }

    public Object fuelCredits(Long driver_id) {

        Query query = Panache.getEntityManager().createQuery("SELECT sum(price) FROM Fuel " +
                "where driver_id = :driver_id");


        query.setParameter("driver_id", driver_id);
        return query.getSingleResult();
    }

    public Object repairCredits(Long driver_id) {

        Query query = Panache.getEntityManager().createQuery("SELECT sum(price) FROM Repair " +
                "where driver_id = :driver_id");


        query.setParameter("driver_id", driver_id);
        return query.getSingleResult();
    }

    public List<Ride> lastRides(Long driver_id) {

        Query query = Panache.getEntityManager().createQuery("SELECT r FROM Ride r " +
                "where driver_id = :driver_id");


        query.setParameter("driver_id", driver_id);
        return query.getResultList();
    }

}
