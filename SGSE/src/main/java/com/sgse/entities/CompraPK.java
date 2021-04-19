/*
  Clase embebible CompraPK correspondiente a las claves primarias de la entidad Compra
*/
package com.sgse.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Embeddable
public class CompraPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_cliente")
    private int idCliente;
    
    @Column(name = "id_seguro")
    private int idSeguro;

    public CompraPK() {
    }

    public CompraPK(int idCliente, int idSeguro) {
        this.idCliente = idCliente;
        this.idSeguro = idSeguro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    
}
