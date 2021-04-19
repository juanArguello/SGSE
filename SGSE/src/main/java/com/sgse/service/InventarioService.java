/*
    Definicion de la interfaz InventarioService
 */
package com.sgse.service;

import com.sgse.entities.Inventario;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface InventarioService {
    // Definicion de los metodos CRUD de la interfaz InventarioService
    public void create(Inventario inventario);
    public Inventario findById(int id);  
    public List<Inventario> findAll();
    public void update(Inventario inventario);
    public void delete(int id);
}
