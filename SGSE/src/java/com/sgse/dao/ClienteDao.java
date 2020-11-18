/*
    Interfaz ClienteDao con sus metodos CRUD
 */
package com.sgse.dao;

import com.sgse.model.entities.Cliente;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */ 
public interface ClienteDao {
    // Definicion de metodos CRUD de la interfaz ClienteDao
    public void create(Cliente cliente);
    public Cliente findById(int id);
    public List<Cliente> findAll();
    public void update(Cliente cliente);
    public void delete(int id);
}
