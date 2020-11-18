/*
  Clase implementadora UsuarioDaoImpl de la interfaz UsuarioDao
 */
package com.sgse.dao;

import com.sgse.model.entities.Usuario;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao{
    
    
//    @Autowired
//    private HibernateTemplate hibernateTemplate;
    
    //Implementacion de los metodos CRUD
    @Override
    @Transactional
    public void create(Usuario usuario) {
        //hibernateTemplate.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findById(int id) {
        //return hibernateTemplate.get(Usuario.class, id);
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Transactional
    @Override
    public void update(Usuario usuario) {
        //hibernateTemplate.update(usuario);
    }

    @Transactional
    @Override
    public void delete(int id) {
        //hibernateTemplate.delete(hibernateTemplate.get(Usuario.class, id));
    }

   
    
}
