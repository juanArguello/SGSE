/*

 */
package com.sgse.dao;

import com.sgse.entities.Permisos;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface PermisoDao {
    // Definicion de metodos CRUD de la interfaz PermisoDao
    public void create(Permisos permisos);
    public Permisos findById(int id);
    public List<Permisos> findAll();
    public void update(Permisos permisos);
    public void delete(int id);
}
