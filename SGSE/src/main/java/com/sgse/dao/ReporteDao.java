/*
    Interfaz ReporteDao con sus metodos CRUD
 */
package com.sgse.dao;

import com.sgse.entities.Reporte;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */ 
public interface ReporteDao {
    // Definicion de metodos CRUD de la interfaz ReporteDao
    public void create(Reporte reporte);
    public Reporte findById(int id);
    public List<Reporte> findAll();
    public void update(Reporte reporte);
    public void delete(int id);
}
