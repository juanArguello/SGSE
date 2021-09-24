/*
    Interfaz UsuarioDao con sus metodos CRUD
 */
package com.sgse.dao;

import com.sgse.entities.Usuario;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface UsuarioDao {
    // Definicion de metodos CRUD de la interfaz UsuarioDao
    public void create(Usuario usuario);
    public Usuario findById(int id);
    public Usuario findByUsername(String username);
    public Usuario findByEmail(String correo);
    public List<Usuario> findAll();
    public void update(Usuario usuario);
    public void delete(int id);
    public int cantidadFilas();
    
}
