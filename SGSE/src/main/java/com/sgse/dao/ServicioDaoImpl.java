/*

 */
package com.sgse.dao;

import com.sgse.model.entities.Servicios;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository(value = "servicioDao")
public class ServicioDaoImpl implements ServicioDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    //Implementacion de los metodos CRUD
    @Transactional
    @Override
    public void create(Servicios servicios) {
        sessionFactory.getCurrentSession().save(servicios);
    }

    @Transactional(readOnly = true)
    @Override
    public Servicios findById(int id) {
        return (Servicios) sessionFactory.getCurrentSession().get(Servicios.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    @SuppressWarnings("unchecked")
    public List<Servicios> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Servicios").list();
    }

    @Transactional
    @Override
    public void update(Servicios servicios) {
        sessionFactory.getCurrentSession().update(servicios);
    }

    @Transactional
    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Servicios.class, id));
    }
    
}
