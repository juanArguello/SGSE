/*
  Clase entidad Empresa correspondiente a la tabla relacional empresa
  con sus respectivo atributos, getters y setters.
 */
package com.sgse.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "ruc")
    private String ruc;
    
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    
    @Column(name = "nombre_marca")
    private String nombreMarca;
    
    @NotEmpty(message = "no puede estar vacio")
    @Email(message = "No es un correo electronico válido")
    @Column(name = "email",unique = true)
    private String email;
    
    @Column(name = "rubro")
    private String rubro;
    
    @JsonIgnoreProperties({"idEmpresa","hibernateLazyInitializer","handler"})
    @OneToMany(mappedBy = "idEmpresa")
    private List<Sucursal> sucursalList;
    
    @JsonIgnoreProperties({"idEmpresa","hibernateLazyInitializer","handler"})
    @OneToMany(mappedBy = "idEmpresa", fetch=FetchType.LAZY)
    private List<Usuario> usuarioList;

    public Empresa() {
        this.sucursalList = new ArrayList<>();
        this.usuarioList = new ArrayList<>();
    }

    public Empresa(Integer id) {
        this.id = id;
    }

    public Empresa(Integer id, String nombreEmpresa, String nombreMarca) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreMarca = nombreMarca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public List<Sucursal> getSucursalList() {
        return Collections.unmodifiableList(sucursalList);
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
    }
        
    public List<Usuario> getUsuarioList() {
        return Collections.unmodifiableList(usuarioList);
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    
}
