/*
 
 */
package com.sgse.dao;

import com.sgse.entities.Servicios;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface ServicioDao {
    // Definicion de metodos CRUD de la interfaz ServicioDao
    public void create(Servicios servicios);
    public Servicios findById(int id);
    public List<Servicios> findAll();
    public void update(Servicios servicios);
    public void delete(int id);
}
