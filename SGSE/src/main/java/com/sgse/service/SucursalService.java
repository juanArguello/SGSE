/*
    Definicion de la interfaz SucursalService
 */
package com.sgse.service;

import com.sgse.entities.Sucursal;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface SucursalService {
    // Definicion de los metodos CRUD de la interfaz SucursalService
    public void create(Sucursal sucursal);
    public Sucursal findById(int id);  
    public List<Sucursal> findAll();
    public void update(Sucursal sucursal);
    public void delete(int id);
}
