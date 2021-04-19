/*
  Clase implementadora RegistrarVentaDaoImpl de la interfaz RegistrarVentaDao
 */
package com.sgse.dao;

import com.sgse.entities.RegistrarVenta;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository("registrarVentaDao")
public class RegistrarVentaDaoImpl implements RegistrarVentaDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(RegistrarVenta registrarVenta) {
        sessionFactory.getCurrentSession()
            .save(registrarVenta);
    }

    @Override
    public RegistrarVenta findById(int id) {
        return sessionFactory.getCurrentSession().get(RegistrarVenta.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<RegistrarVenta> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from RegistrarVenta").list();
    }

    @Override
    public void update(RegistrarVenta registrarVenta) {
        sessionFactory.getCurrentSession().update(registrarVenta);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(RegistrarVenta.class, id));
    }
    
}
