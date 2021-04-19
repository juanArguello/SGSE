/*
  Clase implementadora SucursalDaoImpl de la interfaz SucursalDao
 */
package com.sgse.dao;

import com.sgse.entities.Sucursal;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository("sucursalDao")
public class SucursalDaoImpl implements SucursalDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Sucursal sucursal) {
        sessionFactory.getCurrentSession()
            .save(sucursal);
    }

    @Override
    public Sucursal findById(int id) {
        return sessionFactory.getCurrentSession().get(Sucursal.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Sucursal> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Sucursal").list();
    }

    @Override
    public void update(Sucursal sucursal) {
        sessionFactory.getCurrentSession().update(sucursal);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Sucursal.class, id));
    }
   
}
