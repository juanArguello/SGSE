/*

 */
package com.sgse.dao;

import com.sgse.entities.Rol;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface RolDao {
    // Definicion de metodos CRUD de la interfaz RolDao
    public void create(Rol rol);
    public Rol findById(int id);
    public Rol findByRolName(String nombreRol); 
    public List<Rol> findAll();
    public void update(Rol rol);
    public void delete(int id);
    public int cantidadFilas();
}
