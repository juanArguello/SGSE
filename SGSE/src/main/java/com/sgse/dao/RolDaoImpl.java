/*

 */
package com.sgse.dao;

import com.sgse.entities.Rol;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    @Override
    public void create(Rol rol) {
        sessionFactory.getCurrentSession()
            .save(rol);
    }

    @Override
    public Rol findById(int id) {
        return sessionFactory.getCurrentSession().get(Rol.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Rol> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Rol").list();
    }

    @Override
    public void update(Rol rol) {
        sessionFactory.getCurrentSession()
            .update(rol);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Rol.class, id));
    }
    
}
