/*
    Clase RegistrarVentaServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.RegistrarVentaDao;
import com.sgse.entities.RegistrarVenta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void create(RegistrarVenta registrarVenta) {
        registrarVentaDao.create(registrarVenta);
    }

    @Override
    @Transactional(readOnly = true)
    public RegistrarVenta findById(int id) {
        return registrarVentaDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistrarVenta> findAll() {
        return registrarVentaDao.findAll();
    }

    @Override
    @Transactional
    public void update(RegistrarVenta registrarVenta) {
        registrarVentaDao.update(registrarVenta);
    }

    @Override
    @Transactional
    public void delete(int id) {
        registrarVentaDao.delete(id);
    }
    
}
