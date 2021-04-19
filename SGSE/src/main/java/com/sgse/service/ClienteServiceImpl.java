/*
    Clase ClienteServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.ClienteDao;
import com.sgse.entities.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "clienteService")
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteDao clienteDao;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Cliente cliente) {
        clienteDao.create(cliente);
    }

    @Override
    public Cliente findById(int id) {
        return clienteDao.findById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public void update(Cliente cliente) {
        clienteDao.update(cliente);
    }

    @Override
    public void delete(int id) {
        clienteDao.delete(id);
    }
    
}
