/*
  Clase implementadora UsuarioDaoImpl de la interfaz UsuarioDao
 */
package com.sgse.dao;

import com.sgse.entities.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Repository(value = "usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
//    @Autowired
//    private HibernateTemplate hibernateTemplate;
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    //Implementacion de los metodos CRUD
    @Override
    @Transactional
    public void create(Usuario usuario) {
        //hibernateTemplate.save(usuario);
        getSession().save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(int id) {
        //return hibernateTemplate.get(Usuario.class, id);
        return (Usuario) getSession().get(Usuario.class, id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return (Usuario) getSession()
            .createCriteria(Usuario.class)
            .add(Restrictions.eq("nombreUsuario", username))
            .list().get(0);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario findByEmail(String correo) {
        Query query = getSession().createQuery("from Usuario where email = ? ");
        return (Usuario) query.setParameter(0, correo);
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Usuario> findAll() {
        return getSession().createQuery("from Usuario").list();
    }

    @Override
    @Transactional
    public void update(Usuario usuario) {
        //hibernateTemplate.update(usuario);
        getSession().update(usuario);
    }

    @Override
    @Transactional
    public void delete(int id) {
        //hibernateTemplate.delete(hibernateTemplate.get(Usuario.class, id));
        getSession()
            .delete(getSession().get(Usuario.class, id));
    }
  
    
}
