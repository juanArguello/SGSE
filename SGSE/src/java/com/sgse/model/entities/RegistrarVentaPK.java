/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Juan Carlos Arguello
 * @version 1.0
 */
@Embeddable
public class RegistrarVentaPK implements Serializable {

    @Column(name = "id_usuario")
    private int idUsuario;
    
    @Column(name = "id_seguro")
    private int idSeguro;

    public RegistrarVentaPK() {
    }

    public RegistrarVentaPK(int idUsuario, int idSeguro) {
        this.idUsuario = idUsuario;
        this.idSeguro = idSeguro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }
    
}
