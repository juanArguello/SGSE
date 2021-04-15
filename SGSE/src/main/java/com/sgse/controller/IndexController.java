/*
    El controlador Index se encarga de desplegar el index de pagina
 */
package com.sgse.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Controller
public class IndexController {
    
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String page(Model model) {
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nombre", user.getUsername());
        return "index";
    }
    
    @RequestMapping(value = "/logout")
    public String procesarPassword(String correo){
        return "login";
    }
    
}
