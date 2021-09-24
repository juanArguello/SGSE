/*
  Clase embebible RegistrarVentaPK correspondiente a las claves primarias de la entidad RegistrarVenta
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idUsuario;
        hash = 59 * hash + this.idSeguro;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegistrarVentaPK other = (RegistrarVentaPK) obj;
        if (this.idUsuario != other.getIdUsuario()) {
            return false;
        }else if (this.idSeguro != other.getIdSeguro()) {
            return false;
        }
        return true;
    }
    
    
}
