package com.example.repositories;

import com.example.entities.Settlement;
import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;

@ApplicationScoped
public class SettlementRepository implements PanacheRepository<Settlement> {
    @Transactional
    public void update(Settlement settlement){
        Panache.getEntityManager().merge(settlement);
    }

    public Object getLastSettlement() {
        Query query = Panache.getEntityManager().createQuery("select s from Settlement s where date in (select max(date) from Settlement )");

        return query.getSingleResult();
    }

    public void deleteSettlementData(){
        Query query1 = Panache.getEntityManager().createQuery("delete from Ride");
        Query query2 = Panache.getEntityManager().createQuery("delete from Repair");
        Query query3 = Panache.getEntityManager().createQuery("delete from Fuel");

        query1.executeUpdate();
        query2.executeUpdate();
        query3.executeUpdate();
    }
}
