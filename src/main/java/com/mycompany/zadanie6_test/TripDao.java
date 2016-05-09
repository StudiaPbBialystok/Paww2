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
interface Itrip {

    //  wheel revolutions per minute
    Trip findById(Integer id);

    List<Trip> findByName(String name);

    List<Trip> findAll();

    boolean addTrip(Trip trip);

    boolean editTrip(Trip trip);

    boolean deleteTrip(Trip trip);
}

@Repository("tripDao")
public class TripDao implements Itrip {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Trip findById(Integer id) {
        return (Trip) entityManager.find(Trip.class, id);
    }

//    @Transactional(readOnly = true)
//    public List<Trip> findByName(String name) {
//        return (List<Trip>) entityManager.find(Trip.class, name);
//    }
    public List<Trip> findByName(String name) {
        TypedQuery<Trip> query = entityManager.createNamedQuery("Trip.findByName", Trip.class);
        query.setParameter("name", name);
        return (List<Trip>) query.getResultList();
    }

    public List<Trip> findAll() {
        TypedQuery<Trip> query = entityManager.createNamedQuery("Trip.findAll", Trip.class);
        return (List<Trip>) query.getResultList();
    }

    @Transactional
    public boolean addTrip(Trip trip) {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(trip);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean editTrip(Trip trip) {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(trip);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean deleteTrip(Trip trip) {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        trip = entityManager.merge(trip);
        entityManager.remove(trip);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }
}
