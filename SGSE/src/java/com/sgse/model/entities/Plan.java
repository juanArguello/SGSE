/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Juan Carlos Arguello
 * @version 1.0
 */
@Entity
@Table(name = "plan")
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @JoinTable(name = "plan_servicios", joinColumns = {
        @JoinColumn(name = "id_plan", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_servicio", referencedColumnName = "id")})
    @ManyToMany
    private List<Servicios> serviciosList;
    
    @JoinColumn(name = "id_seguro", referencedColumnName = "id")
    @ManyToOne
    private Seguro idSeguro;

    public Plan() {
    }

    public Plan(Integer id) {
        this.id = id;
    }

    public Plan(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Servicios> getServiciosList() {
        return serviciosList;
    }

    public void setServiciosList(List<Servicios> serviciosList) {
        this.serviciosList = serviciosList;
    }

    public Seguro getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(Seguro idSeguro) {
        this.idSeguro = idSeguro;
    }

    
}
