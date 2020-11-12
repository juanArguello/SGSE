/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Juan Carlos Arguello
 * @version 1.0
 */
@Embeddable
public class CompraPK implements Serializable {

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
