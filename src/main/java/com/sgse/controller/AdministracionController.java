/*
    El controlador Administracion se encarga de gestionar los usuarios, permisos roles
 */
package com.sgse.controller;

import com.sgse.service.PermisoService;
import com.sgse.service.RolService;
import com.sgse.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AdministracionController {

    // Log permite realizar registrar las actividades de los eventos
    private final Log log = LogFactory.getLog(AdministracionController.class);
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private RolService rolService;
    
    @Autowired
    private PermisoService permisoService;
    
   
    @RequestMapping(value = "/administracion",method = RequestMethod.GET)
    public String administracionPage(Model model){
        model.addAttribute("cantidadUsuario",usuarioService.cantidadFilas());
        model.addAttribute("cantidadRol",rolService.cantidadFilas());
        model.addAttribute("cantidadPermiso",permisoService.cantidadFilas());
        log.info("Ingreso al modulo de Administracion");
        return "administracion"; 
    }
    
    @RequestMapping(value = "/usuario",method = RequestMethod.GET)
    public String listarUsuario(){
        log.info("Ingreso al CRUD de Usuarioo");
        return "usuario";
    }
    
    @RequestMapping(value = "/permiso",method = RequestMethod.GET)
    public String vistaPermisos(){
        log.info("Ingreso al CRUD de Permiso");
        return "permiso";
    }
    

}
