/*

 */
package com.sgse.dao;

import com.sgse.entities.Servicios;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    @Override
    public void create(Servicios servicios) {
        sessionFactory.getCurrentSession().save(servicios);
    }

    @Override
    public Servicios findById(int id) {
        return sessionFactory.getCurrentSession().get(Servicios.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Servicios> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Servicios").list();
    }

    @Override
    public void update(Servicios servicios) {
        sessionFactory.getCurrentSession().update(servicios);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Servicios.class, id));
    }
    
}
