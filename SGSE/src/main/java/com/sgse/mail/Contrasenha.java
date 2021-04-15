/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.mail;

import java.util.Random;

/**
 *
 * @author user
 */
public class Contrasenha {
    
    private final int longitud = 8;
    private final char [] caracteres = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
                        'Q','R','S','T','U','V','W','X', 'Y','Z',
                        'a','b','c','d','e','f','g','e','h','i','j','l','k','m',
                        'n','o','p','r','s','t','u','v','w','x','y','z',
                        '0','1','2','3','4','5','6','7','8','9',
                        '@','#','!','$','€','&','[',']','.','+','-','/','*'};

    public Contrasenha() {
    }
    
    
    public String generarContrasenha(){
        String temporal = "";
        Random aleatorio = new Random();
        for(int i = 0; i < longitud; i++){
            temporal += caracteres[aleatorio.nextInt(caracteres.length)];
        }
        return temporal;
    }
    
}
