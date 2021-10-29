/*
    La clase LoginController se encarga de gestionar el login de la aplicacion
    y la recuperacion de contraseña
 */
package com.sgse.controller;

import com.sgse.entities.Usuario;
import com.sgse.mail.Contrasenha;
import com.sgse.service.UsuarioService;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
    private JavaMailSender javaMailSender;
    
    // Log permite realizar registrar las actividades de los eventos
    private final Log log = LogFactory.getLog(LoginController.class);

    @RequestMapping("/login")
    public String loginPage(@ModelAttribute(value = "usuario") Usuario usuario) {
        log.info("Despliegue de panatalla del login");
        return "login";
    }

    @RequestMapping(value = "/login?error=true")
    public String loginError(ModelMap model) {
        log.error("Error de autenticación");
        model.addAttribute("error", true);
        return "login";
    }
    
    @RequestMapping(value = "/acceso-denegado")
    public String accesoDenegado(ModelMap model) {
        return "acceso-denegado";
    }

    @RequestMapping(value = "/recuperar-password", method = RequestMethod.GET)
    public ModelAndView getPasswordPage() {
        log.info("Despliegue de formulario de correo para recuperar password");
        return new ModelAndView("/recuperar-password", "usuario", new Usuario());
    }

    @RequestMapping(value = "/recuperar-password", method = RequestMethod.POST)
    public String obtenerPassword(@ModelAttribute("usuario") Usuario user, 
            ModelMap modelMap) throws MessagingException {
        try {
            Usuario usuario = usuarioService.findByEmail(user.getEmail());
            Contrasenha contrasenha = new Contrasenha();
            String contrasenhaPlana = contrasenha.generarContrasenha();
            usuario.setContrasenha(contrasenha.cifrarContrasenha(contrasenhaPlana));
            log.info("Se obtiene nueva contraseña para el usuario");
            usuarioService.update(usuario);
            enviarContrasenha(usuario, contrasenhaPlana);
            modelMap.addAttribute("recuperar", true);
            return "redirect:/login";
        } catch (Exception e) {
            modelMap.addAttribute("inexistente", true);
            log.error("No existe el correo en el sistema");
            return "redirect:/login";
        }
    }

    private void enviarContrasenha(Usuario usuario, String nuevaContrasenha) {
        final String CORREO_FUTURO = "futuro.seguros.py@gmail.com";
        final String asunto = "Recuperación de contraseña";
        String texto = "<p>Hola " + usuario.getNombre() + " " + usuario.getApellido() + "</p>"
                + "<p>Su nueva contraseña es: " + nuevaContrasenha + "</p>"+
                "<hr><p><strong>Futuro Avda. San Martin N° 615 esq. Sucre</strong></p>";
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            // usa true para indicar que necesita un mensaje multiparte
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(CORREO_FUTURO);
            helper.setTo(usuario.getEmail());
            helper.setSubject(asunto);
            // usa true para indicar el texto incluye como HTML
            texto += "<img src='cid:Futuro' height='100' width='120' />";
            helper.setText(texto, true);
            ClassPathResource classPathResource = new ClassPathResource("/images/logo.jpg");
            helper.addInline("Futuro", classPathResource);
            javaMailSender.send(message);
            log.info("Envio exitosos de contraseña al correo del usuario");
        } catch (MessagingException e) {
            log.error("No se pudo enviar el correo");
        }
    }

}
