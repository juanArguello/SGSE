/*
    Interfaz SucursalDao con sus metodos CRUD
 */
package com.sgse.dao;

import com.sgse.entities.Sucursal;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */ 
public interface SucursalDao {
    // Definicion de metodos CRUD de la interfaz SucursalDao
    public void create(Sucursal sucursal);
    public Sucursal findById(int id);
    public List<Sucursal> findAll();
    public void update(Sucursal sucursal);
    public void delete(int id);
}
