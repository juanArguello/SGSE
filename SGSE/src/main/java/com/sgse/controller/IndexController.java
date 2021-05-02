/*
    El controlador Index se encarga de desplegar el index de pagina
 */
package com.sgse.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Controller
public class IndexController {
    
    // Log permite realizar registrar las actividades de los eventos
    private final Log log = LogFactory.getLog(IndexController.class);
    
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String indexPage(Model model) {
        User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nombre", user.getUsername());
        log.info("Inicio de Sesión exitosa del usuario "+user.getUsername());
        return "index";
    }
    
    @RequestMapping(value = "/login?logout=true",method = RequestMethod.GET)
    public String cerrarSesion(ModelMap model) {
        model.addAttribute("logout", true);
        log.info("Cierre de sesión exitosa");
        return "login";
    }
    
}
