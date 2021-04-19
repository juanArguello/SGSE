/*
 
 */
package com.sgse.dao;

import com.sgse.entities.Permisos;
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
@Repository(value = "permisoDao")
public class PermisoDaoImpl implements PermisoDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    //Implementacion de los metodos CRUD
    @Transactional
    @Override
    public void create(Permisos permisos) {
        sessionFactory.getCurrentSession().save(permisos);
    }

    @Transactional(readOnly = true)
    @Override
    public Permisos findById(int id) {
        return (Permisos) sessionFactory.getCurrentSession().get(Permisos.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    @SuppressWarnings("unchecked")
    public List<Permisos> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Permisos").list();
    }

    @Transactional
    @Override
    public void update(Permisos permisos) {
        sessionFactory.getCurrentSession().update(permisos);
    }

    @Transactional
    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Permisos.class, id));
    }
    
}
