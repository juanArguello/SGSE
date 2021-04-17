/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Component
public class Mailer {
    
//    @Autowired
//    private JavaMailSender javaMailSender;
//    
//    public void enviar(Mensaje mensaje){
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom(mensaje.getRemitente());
//        simpleMailMessage.setTo(mensaje.getDestinatario());
//        simpleMailMessage.setSubject(mensaje.getAsunto());
//        simpleMailMessage.setText(mensaje.getCuerpoMensaje());
//        
//        javaMailSender.send(simpleMailMessage);
//    }
    
}
