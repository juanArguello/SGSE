/*
    Definicion de la interfaz SeguroService
 */
package com.sgse.service;

import com.sgse.entities.Seguro;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface SeguroService {
    // Definicion de los metodos CRUD de la interfaz SeguroService
    public void create(Seguro seguro);
    public Seguro findById(int id);  
    public List<Seguro> findAll();
    public void update(Seguro seguro);
    public void delete(int id);
}
