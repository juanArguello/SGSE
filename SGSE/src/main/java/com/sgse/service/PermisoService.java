/*
    Definicion de la interfaz PermisoService
 */
package com.sgse.service;

import com.sgse.entities.Permisos;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface PermisoService {
    // Definicion de los metodos CRUD de la interfaz PermisoService
    public void create(Permisos permisos);
    public Permisos findById(int id);  
    public List<Permisos> findAll();
    public void update(Permisos permisos);
    public void delete(int id);
}
