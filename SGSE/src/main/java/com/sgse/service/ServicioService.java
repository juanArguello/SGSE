/*
    Definicion de la interfaz ServicioService
 */
package com.sgse.service;

import com.sgse.entities.Servicios;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface ServicioService {
    // Definicion de los metodos CRUD de la interfaz ServicioService
    public void create(Servicios servicios);
    public Servicios findById(int id);  
    public List<Servicios> findAll();
    public void update(Servicios servicios);
    public void delete(int id);
}
