/*
    Clase PlanServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.PlanDao;
import com.sgse.entities.Plan;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "planService")
public class PlanServiceImpl implements PlanService{

    @Autowired
    private PlanDao planDao;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Plan plan) {
        planDao.create(plan);
    }

    @Override
    public Plan findById(int id) {
        return planDao.findById(id);
    }

    @Override
    public List<Plan> findAll() {
        return planDao.findAll();
    }

    @Override
    public void update(Plan plan) {
        planDao.update(plan);
    }

    @Override
    public void delete(int id) {
        planDao.delete(id);
    }
    
}
