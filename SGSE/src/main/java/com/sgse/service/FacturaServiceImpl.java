/*
    Clase FacturaServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.FacturaDao;
import com.sgse.entities.Factura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "facturaService")
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    private FacturaDao facturaDao;
    
    // Implementacion de los metodos CRUD
    @Override
    @Transactional
    public void create(Factura factura) {
        facturaDao.create(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findById(int id) {
        return facturaDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Factura> findAll() {
        return facturaDao.findAll();
    }

    @Override
    @Transactional
    public void update(Factura factura) {
        facturaDao.update(factura);
    }

    @Override
    @Transactional
    public void delete(int id) {
        facturaDao.delete(id);
    }
    
}
