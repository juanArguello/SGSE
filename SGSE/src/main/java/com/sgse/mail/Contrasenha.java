/*
    La clase Contrasenha permite generar una contraseña en forma aleatoria
 */
package com.sgse.mail;

import java.util.Random;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public class Contrasenha {
    
    private final int longitud = 8; // Cantidad maxima de caracteres
    // Los posibles caracteres para la contraseña
    private final char [] caracteres = {'A','B','C','D','E','F','G',
        'H','I','J','K','L','M','N','O','P',
        'Q','R','S','T','U','V','W','X', 'Y','Z',
        '@','#','!','$','&','[',']','.','+','-','/','*','%','_',
        'a','b','c','d','e','f','g','e','h','i','j','l','k','m',
        'n','o','p','r','s','t','u','v','w','x','y','z',
        '0','1','2','3','4','5','6','7','8','9'};

    public Contrasenha() {
    }
    
    /* Permite generar el password en forma aleatoria con una longitud de 8 caracters*/
    public String generarContrasenha(){
        String temporal = "";
        Random aleatorio = new Random();
        for(int i = 0; i < longitud; i++){
            temporal += caracteres[aleatorio.nextInt(caracteres.length)];
        }
        return temporal;
    }
    
}
