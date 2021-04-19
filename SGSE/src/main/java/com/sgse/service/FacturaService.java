/*
    Definicion de la interfaz FacturaService
 */
package com.sgse.service;

import com.sgse.entities.Factura;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface FacturaService {
    // Definicion de los metodos CRUD de la interfaz FacturaService
    public void create(Factura factura);
    public Factura findById(int id);  
    public List<Factura> findAll();
    public void update(Factura factura);
    public void delete(int id);
}
