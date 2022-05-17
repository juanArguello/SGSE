/*
    Clase MailServiceImpl que integra la capa servicio de la aplicacion
 */
package com.sgse.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Service(value = "mailService")
public class MailServiceImpl implements MailService {

    private JavaMailSenderImpl javaMailSenderImpl;

    private String texto;

    private final String CORREO_FUTURO = "futuro.seguros.py@gmail.com";

    // Log permite realizar registrar las actividades de los eventos
    private final Log log = LogFactory.getLog(MailService.class);

    private void inicializar() {
        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty("mail.transport.protocol", "smtp");
        javaMailProperties.setProperty("mail.smtp.auth", "true");
        javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
        javaMailSenderImpl = new JavaMailSenderImpl();
        javaMailSenderImpl.setHost("smtp.gmail.com");
        javaMailSenderImpl.setPort(587);
        javaMailSenderImpl.setUsername("futuro.seguros.py@gmail.com");
        javaMailSenderImpl.setPassword("futuro.seguros.py.2022");
        javaMailSenderImpl.setJavaMailProperties(javaMailProperties);
    }

    @Override
    public void enviarEmail(String destinatario, String asunto, String cuerpoMensaje) {
        inicializar();
        texto = cuerpoMensaje;
        try {
            MimeMessage message = javaMailSenderImpl.createMimeMessage();
            // usa true para indicar que necesita un mensaje multiparte
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(CORREO_FUTURO);
            helper.setTo(destinatario);
            helper.setSubject(asunto);
            texto += "<hr><p><strong>Futuro Avda. San Martin N° 615 esq. Sucre</strong></p>";
            texto += "<img src='cid:Futuro' height='100' width='120' />";
            // usa true para indicar el texto incluye como HTML
            helper.setText(texto, true);
            ClassPathResource classPathResource = new ClassPathResource("/images/logo.jpg");
            helper.addInline("Futuro", classPathResource);
            javaMailSenderImpl.send(message);
            log.info("\n\tEnvio exitoso del correo electronico");
        } catch (MessagingException e) {
            log.error("\n\tNo se pudo enviar el correo");
        }
    }

    @Override
    public void enviarEmailAdjunto(String destinatario, String asunto, String cuerpoMensaje,
        CommonsMultipartFile[] archivoAdjunto) {
        inicializar();
        texto = cuerpoMensaje;
        try {
            MimeMessage message = javaMailSenderImpl.createMimeMessage();
            // use la bandera true para indicar que necesita un mensaje de varias partes
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(CORREO_FUTURO);
            helper.setTo(destinatario);
            helper.setSubject(asunto);
            texto += "<hr><p><strong>Futuro Avda. San Martin N° 615 esq. Sucre</strong></p>";
            texto += "<img src='cid:Futuro' height='100' width='120' />";
            // usa true para indicar el texto incluye como HTML
            helper.setText(texto, true);
            ClassPathResource classPathResource = new ClassPathResource("/images/logo.jpg");
            helper.addInline("Futuro", classPathResource);
            // adjuntamos el archivo 
            List<CommonsMultipartFile> archivos = new ArrayList<>();
            archivos.addAll(Arrays.asList(archivoAdjunto));
            if(!archivos.isEmpty()){
                for (CommonsMultipartFile archivo : archivos) {
                    helper.addAttachment(archivo.getOriginalFilename(), archivo);
                }
            }
            javaMailSenderImpl.send(message); 
        } catch (MessagingException e) {
            log.error("\n\tNo se pudo enviar el correo");
        }
       
        
    }
}
