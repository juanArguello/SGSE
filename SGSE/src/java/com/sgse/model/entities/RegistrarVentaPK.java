/*
  Clase embebible RegistrarVentaPK correspondiente a las claves primarias de la entidad RegistrarVenta
*/
package com.sgse.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Embeddable
public class RegistrarVentaPK implements Serializable {

    private static final long serialVersionUID = 1L;

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
