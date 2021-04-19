/*
    Clase ContratoVentaServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.ContratoVentaDao;
import com.sgse.entities.ContratoVenta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "contratoVentaService")
public class ContratoVentaServiceImpl implements ContratoVentaService{

    @Autowired
    private ContratoVentaDao contratoVentaDao;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(ContratoVenta contratoVenta) {
        contratoVentaDao.create(contratoVenta);
    }

    @Override
    public ContratoVenta findById(int id) {
        return contratoVentaDao.findById(id);
    }

    @Override
    public List<ContratoVenta> findAll() {
        return contratoVentaDao.findAll();
    }

    @Override
    public void update(ContratoVenta contratoVenta) {
        contratoVentaDao.update(contratoVenta);
    }

    @Override
    public void delete(int id) {
        contratoVentaDao.delete(id);
    }
    
}
