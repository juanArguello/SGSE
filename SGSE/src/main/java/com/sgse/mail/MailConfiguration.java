/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.mail;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Configuration
@PropertySource(value = "/WEB-INF/mail.properties")
public class MailConfiguration {
    
    @Autowired
    private Environment environment;
  
    public JavaMailSender mailSender(){
        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        mailSenderImpl.setHost(environment.getProperty("mail.host"));
        mailSenderImpl.setPort(environment.getProperty("mail.port",Integer.class));
        mailSenderImpl.setUsername(environment.getProperty("mail.username"));
        mailSenderImpl.setPassword(environment.getProperty("mail.password"));
        
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.connectiontimeout", 10000);
        
        mailSenderImpl.setJavaMailProperties(properties);
        return mailSenderImpl;
    }
    
}
