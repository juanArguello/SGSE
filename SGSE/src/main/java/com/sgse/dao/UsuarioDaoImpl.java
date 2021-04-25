/*
  Clase implementadora UsuarioDaoImpl de la interfaz UsuarioDao
 */
package com.sgse.dao;

import com.sgse.entities.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository(value = "usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    //Implementacion de los metodos CRUD
    @Override
    public void create(Usuario usuario) {
        //hibernateTemplate.save(usuario);
        getSession().save(usuario);
    }

    @Override
    public Usuario findById(int id) {
        return getSession().get(Usuario.class, id);
    }
    
    @Override
    public Usuario findByUsername(String username) {
        return (Usuario) getSession()
            .createCriteria(Usuario.class)
            .add(Restrictions.eq("nombreUsuario", username)).uniqueResult();
    }
    
    @Override
    public Usuario findByEmail(String correo) {
        return  (Usuario) getSession()
            .createCriteria(Usuario.class)
            .add(Restrictions.eq("email", correo)).uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Usuario> findAll() {
        return getSession().createCriteria(Usuario.class).list();
    }

    @Override
    public void update(Usuario usuario) {
        //hibernateTemplate.update(usuario);
        getSession().update(usuario);
    }

    @Override
    public void delete(int id) {
        //hibernateTemplate.delete(hibernateTemplate.get(Usuario.class, id));
        getSession()
            .delete(getSession().get(Usuario.class, id));
    }
  
    
}
