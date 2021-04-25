/*
    Clase InventarioServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.InventarioDao;
import com.sgse.entities.Inventario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "inventarioService")
public class InventarioServiceImpl implements InventarioService{

    @Autowired
    private InventarioDao inventarioDao;
            
    // Implementacion de los metodos CRUD
    @Override
    @Transactional
    public void create(Inventario inventario) {
        inventarioDao.create(inventario);
    }

    @Override
    @Transactional(readOnly = true)
    public Inventario findById(int id) {
        return inventarioDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inventario> findAll() {
        return inventarioDao.findAll();
    }

    @Override
    @Transactional
    public void update(Inventario inventario) {
        inventarioDao.update(inventario);
    }

    @Override
    @Transactional
    public void delete(int id) {
        inventarioDao.delete(id);
    }
    
}
