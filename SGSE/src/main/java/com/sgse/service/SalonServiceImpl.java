/*
    Clase SalonServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.SalonDao;
import com.sgse.entities.Salon;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "salonService")
public class SalonServiceImpl implements SalonService{

    @Autowired
    private SalonDao salonDao;
    
    // Implementacion de los metodos CRUD
    @Override
    @Transactional
    public void create(Salon salon) {
        salonDao.create(salon);
    }

    @Override
    @Transactional(readOnly = true)
    public Salon findById(int id) {
        return salonDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Salon> findAll() {
        return salonDao.findAll();
    }

    @Override
    @Transactional
    public void update(Salon salon) {
        salonDao.update(salon);
    }

    @Override
    @Transactional
    public void delete(int id) {
        salonDao.delete(id);
    }
    
}
