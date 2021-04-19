/*
  Clase implementadora InventarioDaoImpl de la interfaz InventarioDao
 */
package com.sgse.dao;

import com.sgse.entities.Inventario;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository("inventarioDao")
public class InventarioDaoImpl implements InventarioDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Inventario inventario) {
        sessionFactory.getCurrentSession()
            .save(inventario);
    }

    @Override
    public Inventario findById(int id) {
        return sessionFactory.getCurrentSession().get(Inventario.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Inventario> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Inventario").list();
    }

    @Override
    public void update(Inventario inventario) {
        sessionFactory.getCurrentSession().update(inventario);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Inventario.class, id));
    }
    
}
