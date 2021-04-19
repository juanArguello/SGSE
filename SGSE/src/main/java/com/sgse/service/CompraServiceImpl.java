/*
    Clase CompraServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.CompraDao;
import com.sgse.entities.Compra;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "compraService")
public class CompraServiceImpl implements CompraService{

    @Autowired
    private CompraDao compraDao;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Compra compra) {
        compraDao.create(compra);
    }

    @Override
    public Compra findById(int id) {
        return compraDao.findById(id);
    }

    @Override
    public List<Compra> findAll() {
        return compraDao.findAll();
    }

    @Override
    public void update(Compra compra) {
        compraDao.update(compra);
    }

    @Override
    public void delete(int id) {
        compraDao.delete(id);
    }
    
}
