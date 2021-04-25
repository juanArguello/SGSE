/*
    Definicion de la interfaz UsuarioService
 */
package com.sgse.service;

import com.sgse.entities.Usuario;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface UsuarioService {
    // Definicion de los metodos CRUD de la interfaz UsuarioService
    public void create(Usuario usuario);
    public Usuario findById(int id);  
    public Usuario findByEmail(String correo);
    public List<Usuario> findAll();
    public void update(Usuario usuario);
    public void delete(int id);
}
