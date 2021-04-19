/*
    Definicion de la interfaz ClienteService
 */
package com.sgse.service;

import com.sgse.entities.Cliente;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface ClienteService {
    // Definicion de los metodos CRUD de la interfaz ClienteService
    public void create(Cliente cliente);
    public Cliente findById(int id);
    public List<Cliente> findAll();
    public void update(Cliente cliente);
    public void delete(int id);
}
