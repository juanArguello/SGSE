/*
  La clase LoginController se encarga de gestionar el login de la aplicacion
 */
package com.sgse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Controller
public class LoginController {
   
    @RequestMapping(value = "login.html")
    public String loginPage(){
        return "login";
    }
}
