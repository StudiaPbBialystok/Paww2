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
 *
 */
@Repository("userxDao")
public class UserxDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Userx findById(Integer id) {
        return (Userx) entityManager.find(Userx.class, id);
    }
    

    public List<Userx> findByEmail(String email) {
        TypedQuery<Userx> query = entityManager.createNamedQuery("Userx.findByEmail", Userx.class);
        query.setParameter("email", email);
        return (List<Userx>)query.getResultList();
    }
    
    
}
