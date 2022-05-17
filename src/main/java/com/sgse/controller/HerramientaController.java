/*
    El controlador herramientas se encarga de 
 */
package com.sgse.controller;

import com.sgse.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Controller
@RequestMapping("/herramientas")
public class HerramientaController {
    
    @Autowired
    private MailService mailService;
    
    @RequestMapping(value = "/email",method = RequestMethod.GET)
    public String emailPagina(Model model) {
        model.addAttribute("attribute", "value");
        return "email";
    }
    
    @RequestMapping(value = "/email",method = RequestMethod.POST)
    public String enviarEmail(@RequestParam("correo") String correo, @RequestParam("asunto") String asunto,
            @RequestParam("cuerpoMensaje") String cuerpoMensaje, 
            @RequestParam("archivoAdjunto") CommonsMultipartFile[]  archivoAdjunto, ModelMap modelMap) {
        if(archivoAdjunto.length==0){
            mailService.enviarEmail(correo, asunto, cuerpoMensaje);
        }else{
            mailService.enviarEmailAdjunto(correo, asunto, cuerpoMensaje, archivoAdjunto);
        }
        
        modelMap.addAttribute("enviado", true);
        return "redirect:/index";
    }
    
}
