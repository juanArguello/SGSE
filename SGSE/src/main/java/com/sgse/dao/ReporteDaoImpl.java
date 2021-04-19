/*
  Clase implementadora ReporteDaoImpl de la interfaz ReporteDao
 */
package com.sgse.dao;

import com.sgse.entities.Reporte;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository("reporteDao")
public class ReporteDaoImpl implements ReporteDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Reporte reporte) {
        sessionFactory.getCurrentSession()
            .save(reporte);
    }

    @Override
    public Reporte findById(int id) {
        return sessionFactory.getCurrentSession().get(Reporte.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Reporte> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Reporte").list();
    }

    @Override
    public void update(Reporte reporte) {
        sessionFactory.getCurrentSession().update(reporte);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession()
            .delete(sessionFactory.getCurrentSession().get(Reporte.class, id));
    }
    
}
