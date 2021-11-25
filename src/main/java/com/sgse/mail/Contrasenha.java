/*
    La clase Contrasenha permite generar una contraseña en forma aleatoria
    y cifrar la contraseña.
 */
package com.sgse.mail;

import java.util.Random;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public class Contrasenha {
    
    private String contrasenhaPlana;
    private String contrasenhaCifrada ;
    
    private final int longitud = 8; // Cantidad maxima de caracteres
    // Los posibles caracteres para la contraseña
    private final char [] caracteres = {'A','B','C','D','E','F','G','0','1','2',
                                        '3','4','5','6','7','8','9','H','I','J',
                                        'K','L','M','N','O','P','Q','R','S','T',
                                        'U','V','W','X', 'Y','Z','@','+','-','/',
                                        '*','a','b','c','d','e','f','g','e','h',
                                        'i','j','l','k','m','n','o','p','r','s',
                                        't','u','v','w','x','y','z'};

    public Contrasenha() {
    }

    public String getContrasenhaPlana() {
        return contrasenhaPlana;
    }

    public void setContrasenhaPlana(String contrasenhaPlana) {
        this.contrasenhaPlana = contrasenhaPlana;
    }

    public String getContrasenhaCifrada() {
        return contrasenhaCifrada;
    }

    public void setContrasenhaCifrada(String contrasenhaCifrada) {
        this.contrasenhaCifrada = contrasenhaCifrada;
    }
    
    // cifra la contraseña mediante bcript
    public String cifrarContrasenha(String textoPlano){
        contrasenhaPlana = textoPlano;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2A);
        contrasenhaCifrada = bCryptPasswordEncoder.encode(textoPlano);
        return contrasenhaCifrada;
    }
    
    /* Permite generar el password en forma aleatoria con una longitud de 8 caracters*/
    public String generarContrasenha(){
        String temporal = "";
        Random aleatorio = new Random();
        for(int i = 0; i < longitud; i++){
            temporal += caracteres[aleatorio.nextInt(caracteres.length)];
        }
        contrasenhaPlana = temporal;
        return temporal;
    }
    
}
