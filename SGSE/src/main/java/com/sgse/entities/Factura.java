/*
  Clase entidad Factura correspondiente a la tabla relacional factura
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
@Table(name = "factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nombre_emisor")
    private String nombreEmisor;
    
    @Column(name = "nro_factura")
    private int nroFactura;
    
    @Column(name = "nro_timbrado")
    private int nroTimbrado;
    
    @Column(name = "fecha_limie_validez")
    @Temporal(TemporalType.DATE)
    private Date fechaLimieValidez;
    
    @Column(name = "numeracion")
    private Integer numeracion;
    
    @Column(name = "fecha_factura")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "tipo_pago")
    private String tipoPago;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "ruc_ci_cliente")
    private String rucCiCliente;
    
    @Column(name = "precio_unitario")
    private int precioUnitario;
    
    @Column(name = "valor_iva")
    private int valorIva;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "costo_total")
    private int costoTotal;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "liquidacion_iva")
    private Integer liquidacionIva;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "id_inventario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inventario idInventario;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public Factura() {
    }

    public Factura(Integer id) {
        this.id = id;
    }

    public Factura(Integer id, String nombreEmisor, int nroFactura, int nroTimbrado, String nombreCliente, String tipoPago, String rucCiCliente, int precioUnitario, int valorIva, int cantidad, int costoTotal) {
        this.id = id;
        this.nombreEmisor = nombreEmisor;
        this.nroFactura = nroFactura;
        this.nroTimbrado = nroTimbrado;
        this.nombreCliente = nombreCliente;
        this.tipoPago = tipoPago;
        this.rucCiCliente = rucCiCliente;
        this.precioUnitario = precioUnitario;
        this.valorIva = valorIva;
        this.cantidad = cantidad;
        this.costoTotal = costoTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public int getNroTimbrado() {
        return nroTimbrado;
    }

    public void setNroTimbrado(int nroTimbrado) {
        this.nroTimbrado = nroTimbrado;
    }

    public Date getFechaLimieValidez() {
        return fechaLimieValidez;
    }

    public void setFechaLimieValidez(Date fechaLimieValidez) {
        this.fechaLimieValidez = fechaLimieValidez;
    }

    public Integer getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(Integer numeracion) {
        this.numeracion = numeracion;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRucCiCliente() {
        return rucCiCliente;
    }

    public void setRucCiCliente(String rucCiCliente) {
        this.rucCiCliente = rucCiCliente;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getValorIva() {
        return valorIva;
    }

    public void setValorIva(int valorIva) {
        this.valorIva = valorIva;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getLiquidacionIva() {
        return liquidacionIva;
    }

    public void setLiquidacionIva(Integer liquidacionIva) {
        this.liquidacionIva = liquidacionIva;
    }

    public Inventario getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Inventario idInventario) {
        this.idInventario = idInventario;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    
}
