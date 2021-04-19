/*
  Clase implementadora SalonDaoImpl de la interfaz SalonDao
 */
package com.sgse.dao;

import com.sgse.entities.Salon;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository("salonDao")
public class SalonDaoImpl implements SalonDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Salon salon) {
        sessionFactory.getCurrentSession()
            .save(salon);
    }

    @Override
    public Salon findById(int id) {
        return sessionFactory.getCurrentSession().get(Salon.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Salon> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Salon").list();
    }

    @Override
    public void update(Salon salon) {
        sessionFactory.getCurrentSession().update(salon);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Salon.class, id));
    }
    
}
