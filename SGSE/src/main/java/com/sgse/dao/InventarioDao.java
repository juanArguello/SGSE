/*
    Interfaz InventarioDao con sus metodos CRUD
 */
package com.sgse.dao;

import com.sgse.entities.Inventario;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */ 
public interface InventarioDao {
    // Definicion de metodos CRUD de la interfaz InventarioDao
    public void create(Inventario inventario);
    public Inventario findById(int id);
    public List<Inventario> findAll();
    public void update(Inventario inventario);
    public void delete(int id);
}
