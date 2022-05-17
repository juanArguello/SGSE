/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.controller;

import com.sgse.entities.Usuario;
import com.sgse.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/ventas")
public class VentasController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    private Usuario usuario;
    
    @RequestMapping(value = "/clientes",method = RequestMethod.GET)
    public String getClientes(Model model) {
        model.addAttribute("attribute", "value");
        return "clientes";
    }
    
    @RequestMapping(value = "/registrar",method = RequestMethod.GET)
    public String registrarVentas(Model model) {
        model.addAttribute("", "");
        return "registrar-venta";
    }
    
}
