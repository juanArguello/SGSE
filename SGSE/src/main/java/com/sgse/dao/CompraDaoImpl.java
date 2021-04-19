/*
  Clase implementadora CompraDaoImpl de la interfaz CompraDao
 */
package com.sgse.dao;

import com.sgse.entities.Compra;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository("compraDao")
public class CompraDaoImpl implements CompraDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Compra compra) {
        sessionFactory.getCurrentSession()
            .save(compra);}

    @Override
    public Compra findById(int id) {
        return sessionFactory.getCurrentSession().get(Compra.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Compra> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Compra").list();
    }

    @Override
    public void update(Compra compra) {
        sessionFactory.getCurrentSession().update(compra);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Compra.class, id));
    }
    
}
