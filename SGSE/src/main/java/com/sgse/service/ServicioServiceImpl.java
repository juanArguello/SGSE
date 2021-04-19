/*
    Clase ServicioServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.ServicioDao;
import com.sgse.entities.Servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "servicioService")
public class ServicioServiceImpl implements ServicioService{

    @Autowired
    private ServicioDao servicioDao;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Servicios servicios) {
        servicioDao.create(servicios);
    }

    @Override
    public Servicios findById(int id) {
        return servicioDao.findById(id);
    }

    @Override
    public List<Servicios> findAll() {
        return servicioDao.findAll();
    }

    @Override
    public void update(Servicios servicios) {
        servicioDao.update(servicios);
    }

    @Override
    public void delete(int id) {
        servicioDao.delete(id);
    }
    
}
