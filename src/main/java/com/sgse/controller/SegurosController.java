/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/seguros")
public class SegurosController {
    
    // Log permite realizar registrar las actividades de los eventos
    private final Log log = LogFactory.getLog(SegurosController.class);
    
    @RequestMapping(method = RequestMethod.GET)
    public String segurosPage(Model model){
        model.addAttribute("","");
        log.info("\n\tIngreso al modulo de Seguros");
        return "seguro"; 
    }
    
    @RequestMapping(value = "/plan",method = RequestMethod.GET)
    public String Plan(Model model) {
        log.info("\n\tIngreso al CRUD de plan de seguros");
        model.addAttribute("attribute", "value");
        return "plan";
    }
    
    @RequestMapping(value = "/servicio",method = RequestMethod.GET)
    public String Servicio(Model model) {
        log.info("\n\tIngreso al CRUD de servicios");
        model.addAttribute("attribute", "value");
        return "servicio";
    }
    
}
