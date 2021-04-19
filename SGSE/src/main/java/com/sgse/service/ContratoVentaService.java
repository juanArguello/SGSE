/*
    Definicion de la interfaz ContratoVentaService
 */
package com.sgse.service;

import com.sgse.entities.ContratoVenta;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface ContratoVentaService {
    // Definicion de los metodos CRUD de la interfaz ContratoVentaService
    public void create(ContratoVenta contratoVenta);
    public ContratoVenta findById(int id);  
    public List<ContratoVenta> findAll();
    public void update(ContratoVenta contratoVenta);
    public void delete(int id);
}
