/*
  Clase implementadora EmpresaDaoImpl de la interfaz EmpresaDao
 */
package com.sgse.dao;

import com.sgse.entities.Empresa;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository("empresaDao")
public class EmpresaDaoImpl implements EmpresaDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    // Implementacion de los metodos CRUD
    @Override
    public void create(Empresa empresa) {
        sessionFactory.getCurrentSession()
            .save(empresa);
    }

    @Override
    public Empresa findById(int id) {
        return sessionFactory.getCurrentSession().get(Empresa.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Empresa> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Empresa").list();
    }

    @Override
    public void update(Empresa empresa) {
        sessionFactory.getCurrentSession().update(empresa);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Empresa.class, id));
    }
    
}
