/*
    Interfaz RegistrarVentaDao con sus metodos CRUD
 */
package com.sgse.dao;

import com.sgse.entities.RegistrarVenta;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */ 
public interface RegistrarVentaDao {
    // Definicion de metodos CRUD de la interfaz RegistrarVentaDao
    public void create(RegistrarVenta registrarVenta);
    public RegistrarVenta findById(int id);
    public List<RegistrarVenta> findAll();
    public void update(RegistrarVenta registrarVenta);
    public void delete(int id);
}
