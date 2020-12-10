/*
    El controlador Index se encarga de desplegar el index de pagina
 */
package com.sgse.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Controller
public class IndexController {
    
    @RequestMapping(value = "/index.html")
    public String indexPage(){
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.toString());
        return "index";
    }
}
