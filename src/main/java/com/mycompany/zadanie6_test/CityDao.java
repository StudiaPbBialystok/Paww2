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
@Repository("cityDao")
public class CityDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public City findById(Integer id) {
        return (City) entityManager.find(City.class, id);
    }

    public List<City> findByName(String name) {
        TypedQuery<City> query = entityManager.createNamedQuery("City.findByName", City.class);
        query.setParameter("name", name);
        return (List<City>) query.getResultList();
    }

    public List<City> findAll() {
        TypedQuery<City> query = entityManager.createNamedQuery("City.findAll", City.class);
        return (List<City>) query.getResultList();
    }
    public List<City> findByCountryId(int countryId) {
        TypedQuery<City> query = entityManager.createNamedQuery("City.findByCountryId", City.class);
        query.setParameter("countryid", countryId);
        return (List<City>) query.getResultList();
    }
}
