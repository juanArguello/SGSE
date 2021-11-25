/*
    La clase LoginController se encarga de gestionar el login de la aplicacion
    y la recuperacion de contraseña
 */
package com.sgse.controller;

import com.sgse.entities.Usuario;
import com.sgse.mail.Contrasenha;
import com.sgse.service.MailService;
import com.sgse.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MailService mailService;
    
    // Log permite realizar registrar las actividades de los eventos
    private final Log log = LogFactory.getLog(LoginController.class);

    @RequestMapping("/login")
    public String loginPage(@ModelAttribute(value = "usuario") Usuario usuario) {
        log.info("\n\tDespliegue de panatalla del login");
        return "login";
    }

    @RequestMapping(value = "/login?error=true")
    public String loginError(ModelMap model) {
        log.error("\n\tError de autenticación");
        model.addAttribute("error", true);
        return "login";
    }
    
    @RequestMapping(value = "/acceso-denegado")
    public String accesoDenegado(ModelMap model) {
        log.warn("\n\tAcceso Denegado");
        return "acceso-denegado";
    }

    @RequestMapping(value = "/recuperar-password", method = RequestMethod.GET)
    public ModelAndView getPasswordPage() {
        log.info("\n\tDespliegue de formulario de correo para recuperar password");
        return new ModelAndView("/recuperar-password", "usuario", new Usuario());
    }

    @RequestMapping(value = "/recuperar-password", method = RequestMethod.POST)
    public String obtenerPassword(@ModelAttribute("usuario") Usuario user, ModelMap modelMap){
        try {
            Usuario usuario = usuarioService.findByEmail(user.getEmail());
            Contrasenha contrasenha = new Contrasenha();
            String contrasenhaPlana = contrasenha.generarContrasenha();
            usuario.setContrasenha(contrasenha.cifrarContrasenha(contrasenhaPlana));
            log.info("\n\tSe obtiene nueva contraseña para el usuario");
            usuarioService.update(usuario);
            String texto = "<p>Hola " + usuario.getNombre() + " " + usuario.getApellido() + "</p>"
                + "<p>Su nueva contraseña es: " + contrasenhaPlana + "</p>";
            mailService.enviarEmail(usuario.getEmail(), "Recuperación de contraseña", texto);
            modelMap.addAttribute("recuperar", true);
            return "redirect:/login";
        } catch(Exception e){
            modelMap.addAttribute("inexistente", true);
            log.error("\n\tNo existe el correo en el sistema");
            return "redirect:/login";
        }
    }

}
