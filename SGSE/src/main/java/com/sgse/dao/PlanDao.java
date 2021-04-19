/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.dao;

import com.sgse.entities.Plan;
import java.util.List;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface PlanDao {
    // Definicion de metodos CRUD de la interfaz PlanDao
    public void create(Plan plan);
    public Plan findById(int id);
    public List<Plan> findAll();
    public void update(Plan plan);
    public void delete(int id);
    
}
