/*
    Clase PermisoServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.PermisoDao;
import com.sgse.entities.Permisos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "permisoService")
public class PermisoServiceImpl implements PermisoService{

    @Autowired
    private PermisoDao permisoDao;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Permisos permisos) {
        permisoDao.create(permisos);
    }

    @Override
    public Permisos findById(int id) {
        return permisoDao.findById(id);
    }

    @Override
    public List<Permisos> findAll() {
        return permisoDao.findAll();
    }

    @Override
    public void update(Permisos permisos) {
        permisoDao.update(permisos);
    }

    @Override
    public void delete(int id) {
        permisoDao.delete(id);
    }
    
}
