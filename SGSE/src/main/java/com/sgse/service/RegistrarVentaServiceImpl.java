/*
    Clase RegistrarVentaServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.RegistrarVentaDao;
import com.sgse.entities.RegistrarVenta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "registrarVentaService")
public class RegistrarVentaServiceImpl implements RegistrarVentaService{

    @Autowired
    private RegistrarVentaDao registrarVentaDao;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(RegistrarVenta registrarVenta) {
        registrarVentaDao.create(registrarVenta);
    }

    @Override
    public RegistrarVenta findById(int id) {
        return registrarVentaDao.findById(id);
    }

    @Override
    public List<RegistrarVenta> findAll() {
        return registrarVentaDao.findAll();
    }

    @Override
    public void update(RegistrarVenta registrarVenta) {
        registrarVentaDao.update(registrarVenta);
    }

    @Override
    public void delete(int id) {
        registrarVentaDao.delete(id);
    }
    
}
