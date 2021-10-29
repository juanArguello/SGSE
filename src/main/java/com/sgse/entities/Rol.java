/*
  Clase entidad Rol correspondiente a la tabla relacional rol
  con sus respectivo atributos, getters y setters.
 */
package com.sgse.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
//    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnoreProperties({"rolList","hibernateLazyInitializer","handler"})
    @JoinTable(name = "rol_permisos", joinColumns = {
        @JoinColumn(name = "id_rol", referencedColumnName = "id")}, 
            inverseJoinColumns = {
        @JoinColumn(name = "id_permisos", referencedColumnName = "id")})
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Permisos> permisosList;
    
    
    @JsonIgnoreProperties({"idRol","hibernateLazyInitializer","handler"})
    @OneToMany(mappedBy = "idRol",fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    
    public Rol() {
        this.permisosList = new ArrayList<>();
        this.usuarioList = new ArrayList<>();
    }

    public Rol(Integer id) {
        this.id = id;
    }

    public Rol(Integer id, String nombre) {
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

    public List<Permisos> getPermisosList() {
        return Collections.unmodifiableList(permisosList);
    }

    public void setPermisosList(List<Permisos> permisosList) {
        this.permisosList = permisosList;
    }

    public List<Usuario> getUsuarioList() {
        return Collections.unmodifiableList(usuarioList);
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
    
}
