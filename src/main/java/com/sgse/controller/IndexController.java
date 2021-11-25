/*
    El controlador Index se encarga de desplegar el index de pagina
 */
package com.sgse.controller;

import com.sgse.entities.Usuario;
import com.sgse.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private UsuarioService usuarioService;
    
    // Log permite realizar registrar las actividades de los eventos
    private final Log log = LogFactory.getLog(IndexController.class);
    
    private User user;
    
    private Usuario usuario;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        user = (User) authentication.getPrincipal();
        WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) authentication.getDetails();
        log.info("\n\tInicio de Sesión del usuario: "+user.getUsername()+"   Rol: "+StringUtils.collectionToDelimitedString(user.getAuthorities(), ""));
        log.info("\n\tSesión Id: " + webAuthenticationDetails.getSessionId()+"   Dirección IP: "+webAuthenticationDetails.getRemoteAddress());
        usuario = usuarioService.findByUsername(user.getUsername());
        return "index";
    }

    @RequestMapping(value = "/login?logout=true", method = RequestMethod.GET)
    public String cerrarSesion(Model model) {
        model.addAttribute("logout", true);
        log.info("\n\tCierre de sesión exitosa");
        return "login";
    }
    
    @RequestMapping(value = "/index/user-perfil", method = RequestMethod.GET)
    public ModelAndView perfilUsuario(Model model) {
        log.info("\n\tVisualización del perfil de usuario: "+usuario.getNombreUsuario());
        return new ModelAndView("perfil","perfil-usuario",usuario);
    }
   

}
