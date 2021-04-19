/*
    Definicion de la interfaz SalonService
 */
package com.sgse.service;

import com.sgse.entities.Salon;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface SalonService {
    // Definicion de los metodos CRUD de la interfaz SalonService
    public void create(Salon salon);
    public Salon findById(int id);  
    public List<Salon> findAll();
    public void update(Salon salon);
    public void delete(int id);
}
