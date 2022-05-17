/*
  Clase entidad Usuario correspondiente a la tabla relacional usuario
  con sus respectivo atributos, getters y setters.
 */
package com.sgse.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "cedula",unique = true,nullable = false)
    private Integer cedula;
    
    @Column(name = "ruc",unique = true)
    private String ruc;
    
    @NotEmpty(message = "no puede estar vacio")
    @Column(name = "nombre",nullable = false)
    private String nombre;
    
    @NotEmpty(message = "no puede estar vacio")
    @Column(name = "apellido",nullable = false)
    private String apellido;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
 
    @NotEmpty(message = "no puede estar vacio")
    @Email(message = "No es un correo electronico válido")
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    @Column(name = "estado")
    private String estado;
    
    @NotEmpty(message = "no puede estar vacio")
    @Column(name = "nombre_usuario",unique = true,nullable = false)
    private String nombreUsuario;
    
    @NotEmpty(message = "no puede estar vacio")
    @Column(name = "contrasenha")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String contrasenha;
    
    @JsonIgnoreProperties({"idUsuario","hibernateLazyInitializer","handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<RegistrarVenta> registrarVentaList;
    
    @JsonIgnoreProperties({"idUsuario","hibernateLazyInitializer","handler"})
    @OneToMany( mappedBy = "idUsuario",fetch = FetchType.LAZY)
    private List<Factura> facturaList;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa idEmpresa;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rol idRol;
    
    @JsonIgnoreProperties({"idUsuario","hibernateLazyInitializer","handler"})
    @OneToMany(mappedBy = "idUsuario",fetch = FetchType.LAZY)
    private List<ContratoVenta> contratoVentaList;

    
    /*@PrePersist
    public void prePersist(){
        this.fechaIngreso = new Date();
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public List<RegistrarVenta> getRegistrarVentaList() {
        return Collections.unmodifiableList(registrarVentaList);
    }

    public void setRegistrarVentaList(List<RegistrarVenta> registrarVentaList) {
        this.registrarVentaList = registrarVentaList;
    }

    public List<Factura> getFacturaList() {
        return Collections.unmodifiableList(facturaList);
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public List<ContratoVenta> getContratoVentaList() {
        return Collections.unmodifiableList(contratoVentaList);
    }

    public void setContratoVentaList(List<ContratoVenta> contratoVentaList) {
        this.contratoVentaList = contratoVentaList;
    }

   
}
