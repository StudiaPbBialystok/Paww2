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
 * @author Katarzyna Borowska
 */
@Repository("attractionDao")
public class AttractionDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Attraction findById(Integer id) {
        return (Attraction) entityManager.find(Attraction.class, id);
    }

    public List<Attraction> findByName(String name) {
        TypedQuery<Attraction> query = entityManager.createNamedQuery("Attraction.findByName", Attraction.class);
        query.setParameter("name", name);
        return (List<Attraction>) query.getResultList();
    }

    public List<Attraction> findAll() {
        TypedQuery<Attraction> query = entityManager.createNamedQuery("Attraction.findAll", Attraction.class);
        return (List<Attraction>) query.getResultList();
    }
}
