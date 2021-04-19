/*
    Interfaz SeguroDao con sus metodos CRUD
 */
package com.sgse.dao;

import com.sgse.entities.Seguro;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface SeguroDao {
    // Definicion de metodos CRUD de la interfaz SeguroDao
    public void create(Seguro seguro);
    public Seguro findById(int id);
    public List<Seguro> findAll();
    public void update(Seguro seguro);
    public void delete(int id);
}
