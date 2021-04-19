/*
    Clase EmpresaServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import com.sgse.dao.EmpresaDao;
import com.sgse.entities.Empresa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "empresaService")
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    private EmpresaDao empresaDao;
    
    // Implementacion de los metodos CRUD
    @Override
    public void create(Empresa empresa) {
        empresaDao.create(empresa);
    }

    @Override
    public Empresa findById(int id) {
        return empresaDao.findById(id);
    }

    @Override
    public List<Empresa> findAll() {
        return empresaDao.findAll();
    }

    @Override
    public void update(Empresa empresa) {
        empresaDao.update(empresa);
    }

    @Override
    public void delete(int id) {
        empresaDao.delete(id);
    }
    
}
