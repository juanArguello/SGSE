/*
  Clase implementadora ContratoVentaDaoImpl de la interfaz ContratoVentaDao
 */
package com.sgse.dao;

import com.sgse.entities.ContratoVenta;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository("contratoVentaDao")
public class ContratoVentaDaoImpl implements ContratoVentaDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(ContratoVenta contratoVenta) {
        sessionFactory.getCurrentSession()
            .save(contratoVenta);
    }

    @Override
    public ContratoVenta findById(int id) {
        return sessionFactory.getCurrentSession().get(ContratoVenta.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ContratoVenta> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from ContratoVenta").list();
    }

    @Override
    public void update(ContratoVenta contratoVenta) {
        sessionFactory.getCurrentSession().update(contratoVenta);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(ContratoVenta.class, id));
    }
    
}
