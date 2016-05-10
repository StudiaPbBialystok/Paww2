/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zadanie6_test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kamil
 */
@Repository("stopDao")
public class StopDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Stop findById(Integer id) {
        return (Stop) entityManager.find(Stop.class, id);
    }
    
     public List<Stop> findAll() {
        TypedQuery<Stop> query = entityManager.createNamedQuery("Stop.findAll", Stop.class);
        return (List<Stop>) query.getResultList();
    }

    public List<Stop> findByName(String name) {
        TypedQuery<Stop> query = entityManager.createNamedQuery("Stop.findByName", Stop.class);
        query.setParameter("name", name);
        return (List<Stop>) query.getResultList();
    }

    public List<Stop> findByTripId(int tripId) {
        TypedQuery<Stop> query = entityManager.createNamedQuery("Stop.findByTripid", Stop.class);
        query.setParameter("tripid", tripId);
        return (List<Stop>) query.getResultList();
    }
    
     public List<Stop> findAfterDate(String date) {
        TypedQuery<Stop> query = entityManager.createNamedQuery("Stop.findAfterDate", Stop.class);
        query.setParameter("date", date);
        return (List<Stop>) query.getResultList();
    }

    @Transactional
    public boolean addStop(Stop stop) {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(stop);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }
    
     @Transactional
    public boolean deleteStop(Stop stop) {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        stop = entityManager.merge(stop);
        entityManager.remove(stop);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }

}
