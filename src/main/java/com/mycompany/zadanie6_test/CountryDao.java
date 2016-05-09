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
@Repository("countryDao")
public class CountryDao {
    
      @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Country findById(Integer id) {
        return (Country) entityManager.find(Country.class, id);
    }
    
     public List<Country> findByName(String name)
    {
        TypedQuery<Country> query=entityManager.createNamedQuery("Country.findByName", Country.class);
        query.setParameter("name", name);
        return (List<Country>)query.getResultList();
    }
    
}
