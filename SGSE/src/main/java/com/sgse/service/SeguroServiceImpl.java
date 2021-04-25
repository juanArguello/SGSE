/*
    Clase SeguroServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.SeguroDao;
import com.sgse.entities.Seguro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "seguroService")
public class SeguroServiceImpl implements SeguroService{

    @Autowired
    private SeguroDao seguroDao;
    
    // Implementacion de los metodos CRUD
    @Override
    @Transactional
    public void create(Seguro seguro) {
        seguroDao.create(seguro);
    }

    @Override
    @Transactional(readOnly = true)
    public Seguro findById(int id) {
        return seguroDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Seguro> findAll() {
        return seguroDao.findAll();
    }

    @Override
    @Transactional
    public void update(Seguro seguro) {
        seguroDao.update(seguro);
    }

    @Override
    @Transactional
    public void delete(int id) {
        seguroDao.delete(id);
    }
    
}
