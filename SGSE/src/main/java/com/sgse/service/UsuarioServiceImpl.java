/*
    Clase UsuarioServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.UsuarioDao;
import com.sgse.entities.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioDao usuarioDao;

    // Implementacion de los metodos CRUD
    @Override
    public void create(Usuario usuario) {
        usuarioDao.create(usuario);
    }

    @Override
    public Usuario findById(int id) {
        return usuarioDao.findById(id);
    }
   
    @Override
    public Usuario buscarPorCorreo(String correo) {
        return usuarioDao.findByEmail(correo);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    @Override
    public void update(Usuario usuario) {
        usuarioDao.update(usuario);
    }

    @Override
    public void delete(int id) {
        usuarioDao.delete(id);
    }

}
