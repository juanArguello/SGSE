/*
    Definicion de la interfaz MailService
 */
package com.sgse.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
public interface MailService {
    
    public void enviarEmail(String destinatario, String asunto, String cuerpoMensaje);
    public void enviarEmailAdjunto(String destinatario, String asunto, String cuerpoMensaje,
        CommonsMultipartFile[] archivoAdjunto );
}
