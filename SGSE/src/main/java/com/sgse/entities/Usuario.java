/*
  Clase entidad Usuario correspondiente a la tabla relacional usuario
  con sus respectivo atributos, getters y setters.
 */
package com.sgse.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
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
    
    @Column(name = "cedula",nullable = false)
    private Integer cedula;
    
    @Column(name = "ruc")
    private String ruc;
    
    @NotEmpty(message = " no puede estar vacio")
    @Size(min = 5, max = 15)
    @Column(name = "nombre",nullable = false)
    private String nombre;
    
    @NotEmpty(message = " no puede estar vacio")
    @Size(min = 5, max = 15)
    @Column(name = "apellido",nullable = false)
    private String apellido;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
    
    @NotEmpty(message = " no puede estar vacio")
    @Email(message = "No es una dirección de correo bien formada")
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    
    @Column(name = "contrasenha")
    private String contrasenha;
    
    @OneToMany(mappedBy = "usuario")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<RegistrarVenta> registrarVentaList;
    
    @OneToMany(mappedBy = "idUsuario")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Factura> facturaList;
    
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne
    private Empresa idEmpresa;
    
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    @ManyToOne
    private Rol idRol;
    
    @OneToMany(mappedBy = "idUsuario")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ContratoVenta> contratoVentaList;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nombre, String apellido, Date fechaIngreso, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }
    
    @PrePersist
    public void prePersist(){
        this.fechaIngreso = new Date();
    }

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
        return registrarVentaList;
    }

    public void setRegistrarVentaList(List<RegistrarVenta> registrarVentaList) {
        this.registrarVentaList = registrarVentaList;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
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
        return contratoVentaList;
    }

    public void setContratoVentaList(List<ContratoVenta> contratoVentaList) {
        this.contratoVentaList = contratoVentaList;
    }

   
}
