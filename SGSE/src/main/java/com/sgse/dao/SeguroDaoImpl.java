/*
  Clase implementadora SeguroDaoImpl de la interfaz SeguroDao
 */
package com.sgse.dao;

import com.sgse.entities.Seguro;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository("seguroDao")
public class SeguroDaoImpl implements SeguroDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Seguro seguro) {
        sessionFactory.getCurrentSession()
            .save(seguro);
    }

    @Override
    public Seguro findById(int id) {
        return sessionFactory.getCurrentSession().get(Seguro.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Seguro> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Seguro").list();
    }

    @Override
    public void update(Seguro seguro) {
        sessionFactory.getCurrentSession().update(seguro);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Seguro.class, id));
    }
    
}
