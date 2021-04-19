/*
  Clase implementadora ClienteDaoImpl de la interfaz ClienteDao
 */

package com.sgse.dao;

import com.sgse.entities.Cliente;
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
@Repository("clienteDao")
public class ClienteDaoImpl implements ClienteDao{

    @Autowired
    private SessionFactory sessionFactory;

    // Implementacion de los metodos CRUD
    @Override
    public void create(Cliente cliente) {
        sessionFactory.getCurrentSession()
            .save(cliente);
    }

    @Override
    public Cliente findById(int id) {
        return sessionFactory.getCurrentSession().get(Cliente.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Cliente> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Cliente").list();
    }

    @Override
    public void update(Cliente cliente) {
        sessionFactory.getCurrentSession().update(cliente);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Cliente.class, id));
    }
    
}
