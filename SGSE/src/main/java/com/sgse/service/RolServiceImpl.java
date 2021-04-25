/*
    Clase RolServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.RolDao;
import com.sgse.entities.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "rolService")
public class RolServiceImpl implements RolService{

    @Autowired
    private RolDao rolDao;
    
    // Implementacion de los metodos CRUD
    @Override
    @Transactional
    public void create(Rol rol) {
        rolDao.create(rol);
    }

    @Override
    @Transactional(readOnly = true)
    public Rol findById(int id) {
        return rolDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return rolDao.findAll();
    }

    @Override
    @Transactional
    public void update(Rol rol) {
        rolDao.update(rol);
    }

    @Override
    @Transactional
    public void delete(int id) {
        rolDao.delete(id);
    }
    
}
