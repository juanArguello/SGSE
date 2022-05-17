/*
  Clase entidad Permisos correspondiente a la tabla relacional permisos
  con sus respectivo atributos, getters y setters.
 */
package com.sgse.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Entity
@Table(name = "permisos")
public class Permisos implements Serializable{

    private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @NotEmpty(message = "no puede estar vacio")
    @Column(name = "nombre",unique = true)
    private String nombre;
    
    @NotEmpty(message = "no puede estar vacio")
    @Column(name = "descripcion")
    private String descripcion;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnoreProperties(value = {"permisosList","hibernateLazyInitializer","handler"})
    @ManyToMany(mappedBy = "permisosList",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Rol> rolList;

    public Permisos() {
        this.rolList = new ArrayList<>();
    }

    public Permisos(Integer id) {
        this.id = id;
    }

    public Permisos(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public List<Rol> getRolList() {
        return Collections.unmodifiableList(rolList);
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

   
}
