/*
    Clase PermisoServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.PermisoDao;
import com.sgse.entities.Permisos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void create(Permisos permisos) {
        permisoDao.create(permisos);
    }

    @Override
    @Transactional(readOnly = true)
    public Permisos findById(int id) {
        return permisoDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Permisos> findAll() {
        return permisoDao.findAll();
    }

    @Override
    @Transactional
    public void update(Permisos permisos) {
        permisoDao.update(permisos);
    }

    @Override
    @Transactional
    public void delete(int id) {
        permisoDao.delete(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public int cantidadFilas() {
        return permisoDao.cantidadFilas();
    }

    
}
