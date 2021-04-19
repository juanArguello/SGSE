/*
    Definicion de la interfaz CompraService
 */
package com.sgse.service;

import com.sgse.entities.Compra;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface CompraService {
    // Definicion de los metodos CRUD de la interfaz CompraService
    public void create(Compra compra);
    public Compra findById(int id);  
    public List<Compra> findAll();
    public void update(Compra compra);
    public void delete(int id);
}
