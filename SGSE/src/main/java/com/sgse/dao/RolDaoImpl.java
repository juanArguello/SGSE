/*

 */
package com.sgse.dao;

import com.sgse.entities.Rol;
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
@Repository(value = "rolDao")
public class RolDaoImpl implements RolDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    //Implementacion de los metodos CRUD
    @Transactional
    @Override
    public void create(Rol rol) {
        sessionFactory.getCurrentSession()
            .save(rol);
    }

    @Transactional(readOnly = true)
    @Override
    public Rol findById(int id) {
        return (Rol) sessionFactory.getCurrentSession().get(Rol.class, id);
    }

    @Transactional(readOnly = true)
    @Override
    @SuppressWarnings("unchecked")
    public List<Rol> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Rol").list();
    }

    @Transactional
    @Override
    public void update(Rol rol) {
        sessionFactory.getCurrentSession()
            .update(rol);
    }

    @Transactional
    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Rol.class, id));
    }
    
}
