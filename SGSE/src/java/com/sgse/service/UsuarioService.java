/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.service;

import com.sgse.dao.UsuarioDao;
import com.sgse.model.entities.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDao usuarioDao;

    public void create(Usuario usuario) {
        usuarioDao.create(usuario);
    }

    public Usuario findById(int id) {
        return usuarioDao.findById(id);
    }

    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    public void update(Usuario usuario) {
        usuarioDao.update(usuario);
    }

    public void delete(int id) {
        usuarioDao.delete(id);
    }

    public int cantidad() {
        return 0;
    }
    
}
