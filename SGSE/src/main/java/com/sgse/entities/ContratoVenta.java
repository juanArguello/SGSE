/*
  Clase entidad ContratoVenta correspondiente a la tabla relacional contrato_venta
  con sus respectivo atributos, getters y setters.
 */
package com.sgse.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "contrato_venta")
public class ContratoVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "cedula")
    private int cedula;
    
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "paquete_seguro")
    private String paqueteSeguro;
    
    @Column(name = "costo")
    private int costo;
    
    @Column(name = "tipo_pago")
    private int tipoPago;
    
    @Column(name = "observacion")
    private String observacion;
    
    @Column(name = "modo_pago")
    private String modoPago;
    
    @Column(name = "tipo_servicio")
    private String tipoServicio;
    
    @JsonIgnoreProperties({"contrato_venta","hibernateLazyInitializer","handler"})
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Usuario idUsuario;

    public ContratoVenta() {
    }

    public ContratoVenta(Integer id) {
        this.id = id;
    }

    public ContratoVenta(Integer id, int cedula, String nombreCliente, Date fecha, String paqueteSeguro, int costo, int tipoPago, String modoPago, String tipoServicio) {
        this.id = id;
        this.cedula = cedula;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.paqueteSeguro = paqueteSeguro;
        this.costo = costo;
        this.tipoPago = tipoPago;
        this.modoPago = modoPago;
        this.tipoServicio = tipoServicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPaqueteSeguro() {
        return paqueteSeguro;
    }

    public void setPaqueteSeguro(String paqueteSeguro) {
        this.paqueteSeguro = paqueteSeguro;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getModoPago() {
        return modoPago;
    }

    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
