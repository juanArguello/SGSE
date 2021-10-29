/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
public class FacturacionController {
    
    @RequestMapping("/facturacion")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "facturacion";
    }
    
}
