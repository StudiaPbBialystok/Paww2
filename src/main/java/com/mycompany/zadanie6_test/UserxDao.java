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
interface Iuser {

    //  wheel revolutions per minute
    Userx findById(Integer id);

    List<Userx> findByName(String name);

    List<Userx> findAll();

    boolean addUser(Userx user);

}

@Repository("userxDao")
public class UserxDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(readOnly = true)
    public Userx findById(Integer id) {
        return (Userx) entityManager.find(Userx.class, id);
    }

    @Transactional(readOnly = true)
    public Userx findUser(String email, String password) {
        TypedQuery<Userx> query = entityManager.createNamedQuery("Userx.findByLastChristmas", Userx.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        return (Userx) query.getSingleResult();
    }
    
    @Transactional(readOnly = true)
    public Userx findUserEmail2(String email) {
        TypedQuery<Userx> query = entityManager.createNamedQuery("Userx.findByEmail", Userx.class);        
        query.setParameter("email", email);       
        return (Userx) query.getSingleResult();
    }

    @Transactional
    public boolean addUser(Userx user) {
        entityManager = entityManager.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }

    public List<Userx> findAll() {
        TypedQuery<Userx> query = entityManager.createNamedQuery("Userx.findAll", Userx.class);
        return (List<Userx>) query.getResultList();
    }

    public List<Userx> findByEmail(String email) {
        TypedQuery<Userx> query = entityManager.createNamedQuery("Userx.findByEmail", Userx.class);
        query.setParameter("email", email);
        return (List<Userx>) query.getResultList();
    }

}
