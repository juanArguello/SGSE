/*
    El controlador Index se encarga de desplegar el index de pagina
 */
package com.sgse.controller;

import com.sgse.config.custom.CustomPermissionEvaluator;
import com.sgse.entities.Usuario;
import com.sgse.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Controller
public class IndexController {
    
    // Log permite realizar registrar las actividades de los eventos
    private final Log log = LogFactory.getLog(IndexController.class);
    
    @Autowired
    private UsuarioService usuarioService;
    
    private Usuario usuario;
    
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(Authentication authentication, Model model) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        usuario = usuarioService.findByUsername(authentication.getName());
        log.info("\n\tInicio de Sesion del usuario: "+authentication.getName()+" Rol: "+authentication.getAuthorities());
        return "index";
    }

    @RequestMapping(value = "/login?logout=true", method = RequestMethod.GET)
    public String cerrarSesion(Model model) {
        model.addAttribute("logout", true);
        log.info("\n\tCierre de sesión exitosa");
        return "login";
    }
    
    @RequestMapping(value = "/user/perfil", method = RequestMethod.GET)
    public ModelAndView perfilUsuario(Model model) {
        log.info("\n\tVisualización del perfil de usuario: "+usuario.getNombreUsuario());
        return new ModelAndView("perfil","perfil-usuario",usuario);
    }
   

}
