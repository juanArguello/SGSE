/*
  Clase entidad RegistrarVenta correspondiente a la tabla relacional registrar_venta
  con sus respectivo atributos, getters y setters.
 */
package com.sgse.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Entity
@Table(name = "registrar_venta")
public class RegistrarVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private RegistrarVentaPK registrarVentaPK;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "monto")
    private int monto;
    
    @Column(name = "tipo_venta")
    private String tipoVenta;
    
    @JoinColumn(name = "id_seguro", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Seguro seguro;
    
    @JsonIgnoreProperties({"registrar_venta","hibernateLazyInitializer","handler"})
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public RegistrarVenta() {
    }

    public RegistrarVenta(RegistrarVentaPK registrarVentaPK) {
        this.registrarVentaPK = registrarVentaPK;
    }

    public RegistrarVenta(RegistrarVentaPK registrarVentaPK, Date fecha, int monto) {
        this.registrarVentaPK = registrarVentaPK;
        this.fecha = fecha;
        this.monto = monto;
    }

    public RegistrarVenta(int idUsuario, int idSeguro) {
        this.registrarVentaPK = new RegistrarVentaPK(idUsuario, idSeguro);
    }

    public RegistrarVentaPK getRegistrarVentaPK() {
        return registrarVentaPK;
    }

    public void setRegistrarVentaPK(RegistrarVentaPK registrarVentaPK) {
        this.registrarVentaPK = registrarVentaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

  
}
