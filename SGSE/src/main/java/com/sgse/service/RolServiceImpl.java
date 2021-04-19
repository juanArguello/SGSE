/*
    Clase RolServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.RolDao;
import com.sgse.entities.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void create(Rol rol) {
        rolDao.create(rol);
    }

    @Override
    public Rol findById(int id) {
        return rolDao.findById(id);
    }

    @Override
    public List<Rol> findAll() {
        return rolDao.findAll();
    }

    @Override
    public void update(Rol rol) {
        rolDao.update(rol);
    }

    @Override
    public void delete(int id) {
        rolDao.delete(id);
    }
    
}
