/*
    Definicion de la interfaz RolService
 */
package com.sgse.service;

import com.sgse.entities.Rol;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface RolService {
    // Definicion de los metodos CRUD de la interfaz RolService
    public void create(Rol rol);
    public Rol findById(int id);  
    public List<Rol> findAll();
    public void update(Rol rol);
    public void delete(int id);
}
