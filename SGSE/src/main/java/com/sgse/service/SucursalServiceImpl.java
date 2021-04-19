/*
    Clase SucursalServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.SucursalDao;
import com.sgse.entities.Sucursal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "sucursalService")
public class SucursalServiceImpl implements SucursalService{

    @Autowired
    private SucursalDao sucursalDao;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Sucursal sucursal) {
        sucursalDao.create(sucursal);
    }

    @Override
    public Sucursal findById(int id) {
        return sucursalDao.findById(id);
    }

    @Override
    public List<Sucursal> findAll() {
        return sucursalDao.findAll();
    }

    @Override
    public void update(Sucursal sucursal) {
        sucursalDao.update(sucursal);
    }

    @Override
    public void delete(int id) {
        sucursalDao.delete(id);
    }
    
}
