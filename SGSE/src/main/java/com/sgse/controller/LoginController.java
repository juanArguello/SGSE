/*
    La clase LoginController se encarga de gestionar el login de la aplicacion
 */
package com.sgse.controller;

import com.sgse.mail.Contrasenha;
import com.sgse.entities.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Controller
public class LoginController {
    
    @RequestMapping("login")
    public String page(@ModelAttribute(value = "usuario")Usuario usuario) {
        return "login";
    }
    
    @RequestMapping(value = "/login?error=true")
    public String loginError(ModelMap model) {
        model.addAttribute("error", true);
        return "login";

    }
    
    @RequestMapping(value = "/recuperar-password",method = RequestMethod.GET)
    public String recuperarPassword(){
        return "recuperar-password";
    }
    
    @RequestMapping(value = "/recuperar")
    public String obtenerPassword(@ModelAttribute(value = "correo")String correo){
        
              
        Contrasenha contrasenha = new Contrasenha();
        contrasenha.generarContrasenha();
        return "login";
    }
    
    
    
}
