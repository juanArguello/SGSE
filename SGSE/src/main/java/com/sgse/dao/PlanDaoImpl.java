/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.dao;

import com.sgse.entities.Plan;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository(value = "planDao")
public class PlanDaoImpl implements PlanDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    // Implementacion de los metodos CRUD
    @Override
    public void create(Plan plan) {
       sessionFactory.getCurrentSession()
            .persist(plan);
    }

    @Override
    public Plan findById(int id) {
        return sessionFactory.getCurrentSession().get(Plan.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Plan> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Plan").list();
    }
        
    @Override
    public void update(Plan plan) {
        sessionFactory.getCurrentSession().update(plan);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Plan.class, id));
    }
    
}
