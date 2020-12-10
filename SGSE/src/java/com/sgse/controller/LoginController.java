/*
    La clase LoginController se encarga de gestionar el login de la aplicacion
 */
package com.sgse.controller;

import com.sgse.model.entities.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Controller
public class LoginController {
   
    @RequestMapping(value = "/login.html")
    public String loginPage(@ModelAttribute(value = "usuario")Usuario usuario){
        return "login";
    }
    
    @RequestMapping(value = "/login.html?error=true")
    public String loginError(ModelMap model) {
        model.addAttribute("error", true);
        return "login";

    }
    
    @RequestMapping(value = "recuperar-password.html")
    public String recuperarPassword(){
        return "recuperar-password";
    }
}
