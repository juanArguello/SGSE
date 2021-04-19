/*
    Clase ReporteServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.ReporteDao;
import com.sgse.entities.Reporte;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "reporteService")
public class ReporteServiceImpl implements ReporteService{

    @Autowired
    private ReporteDao reporteDao;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Reporte reporte) {
        reporteDao.create(reporte);
    }

    @Override
    public Reporte findById(int id) {
        return reporteDao.findById(id);
    }

    @Override
    public List<Reporte> findAll() {
        return reporteDao.findAll();
    }

    @Override
    public void update(Reporte reporte) {
        reporteDao.update(reporte);
    }

    @Override
    public void delete(int id) {
        reporteDao.delete(id);
    }
    
}
