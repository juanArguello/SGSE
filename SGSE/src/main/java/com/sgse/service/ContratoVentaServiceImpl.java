/*
    Clase ContratoVentaServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.ContratoVentaDao;
import com.sgse.entities.ContratoVenta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void create(ContratoVenta contratoVenta) {
        contratoVentaDao.create(contratoVenta);
    }

    @Override
    @Transactional(readOnly = true)
    public ContratoVenta findById(int id) {
        return contratoVentaDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratoVenta> findAll() {
        return contratoVentaDao.findAll();
    }

    @Override
    @Transactional
    public void update(ContratoVenta contratoVenta) {
        contratoVentaDao.update(contratoVenta);
    }

    @Override
    @Transactional
    public void delete(int id) {
        contratoVentaDao.delete(id);
    }
    
}
