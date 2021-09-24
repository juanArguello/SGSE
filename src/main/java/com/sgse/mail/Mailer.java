/*
 
 */
package com.sgse.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public class Mailer {
     
    @Autowired
    private JavaMailSender javaMailSender;
    
    private String texto;
        
    private final String CORREO_FUTURO = "futuro.seguros.py@gmail.com";
    
    // Log permite realizar registrar las actividades de los eventos
    private final Log log = LogFactory.getLog(Mailer.class);

    public Mailer() {
    }
   
    public void enviarEmail(String destinatario, String asunto, String cuerpoMensaje){
        texto = cuerpoMensaje;
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            // usa true para indicar que necesita un mensaje multiparte
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(CORREO_FUTURO);
            helper.setTo(destinatario);
            helper.setSubject(asunto);
            // usa true para indicar el texto incluye como HTML
            texto += "<img src='cid:Futuro' height='100' width='120' />";
            helper.setText(texto, true);
            ClassPathResource classPathResource = new ClassPathResource("/images/logo.jpg");
            helper.addInline("Futuro", classPathResource);
            javaMailSender.send(message);
            log.info("Envio exitosos de contraseña al correo del usuario");
        } catch (MessagingException e) {
            log.error("No se pudo enviar el correo");
        }
    }
    
     public void enviarEmailAdjunto(String destinatario, String asunto, String cuerpoMensaje,
            Object archivoAdjunto ){
         
     }
}
