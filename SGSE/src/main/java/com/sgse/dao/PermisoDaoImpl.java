/*
 
 */
package com.sgse.dao;

import com.sgse.entities.Permisos;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository(value = "permisoDao")
public class PermisoDaoImpl implements PermisoDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    //Implementacion de los metodos CRUD
    @Override
    public void create(Permisos permisos) {
        sessionFactory.getCurrentSession().save(permisos);
    }

    @Override
    public Permisos findById(int id) {
        return sessionFactory.getCurrentSession().get(Permisos.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Permisos> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Permisos.class).list();
    }

    @Override
    public void update(Permisos permisos) {
        sessionFactory.getCurrentSession().update(permisos);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Permisos.class, id));
    }
    
}
