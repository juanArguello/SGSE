/*

 */
package com.sgse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */

@Service
public class SendMailService {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    public void enviarEmail(){
        
    }
}
