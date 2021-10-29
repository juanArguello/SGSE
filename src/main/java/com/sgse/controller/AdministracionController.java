/*
    El controlador Administracion se encarga de gestionar los usuarios, permisos roles
 */
package com.sgse.controller;

import com.sgse.entities.Permisos;
import com.sgse.entities.Rol;
import com.sgse.entities.Usuario;
import com.sgse.service.PermisoService;
import com.sgse.service.RolService;
import com.sgse.service.UsuarioService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/administracion")
public class AdministracionController {

    // Log permite realizar registrar las actividades de los eventos
    private final Log log = LogFactory.getLog(AdministracionController.class);
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private RolService rolService;
    
    @Autowired
    private PermisoService permisoService;;
    
   
    @RequestMapping(method = RequestMethod.GET)
    public String administracionPage(Model model){
        model.addAttribute("cantidadUsuario",usuarioService.cantidadFilas());
        model.addAttribute("cantidadRol",rolService.cantidadFilas());
        model.addAttribute("cantidadPermiso",permisoService.cantidadFilas());
        log.info("Ingreso al modulo de Administracion");
        return "administracion"; 
    }
    
    @RequestMapping(value = "/usuario",method = RequestMethod.GET)
    public String listarUsuario(){
        log.info("Ingreso al CRUD de Usuario");
        return "usuario";
    }
    
    @RequestMapping(value = "/usuario/add",method = RequestMethod.GET)
    public ModelAndView addUsuario(Model model){
        model.addAttribute("roles", rolService.findAll());
        log.info("Agregar nuevo Usuario");
        return new ModelAndView("add-usuario","nuevo-usuario",new Usuario());
    }
    
    @RequestMapping(value = "/usuario/edit/{id}",method = RequestMethod.GET)
    public ModelAndView editUsuario(@PathVariable("id")String id, Model model){
        Usuario usuario = usuarioService.findById(Integer.parseInt(id));
        model.addAttribute("rolSeleccionado", usuario.getIdRol().getId());
        model.addAttribute("roles", rolService.findAll());
        log.info("Editar el Usuario "+usuario.getNombreUsuario());
        return new ModelAndView("edit-usuario","editar-usuario",usuario);
    }
    
    @RequestMapping(value = "/roles",method = RequestMethod.GET)
    public String listarRoles(){
        log.info("Ingreso al listado de roles");
        return "roles";
    }
    
    @RequestMapping(value = "/roles/add",method = RequestMethod.GET)
    public ModelAndView addRoles(Model model){
        model.addAttribute("permisos", permisoService.findAll());
        return new ModelAndView("add-rol", "nuevo-rol", new Rol());
    }
    
    @RequestMapping(value = "/roles/edit/{id}",method = RequestMethod.GET)
    public ModelAndView editRol(@PathVariable("id")String id, Model model){
        Rol rol = rolService.findById(Integer.valueOf(id));
        List<Permisos> permisosRegistrado = permisoService.findAll();
        Set<Permisos> permisoNoSeleccionado = new HashSet<>();
        List<Permisos> permisoSeleccionado =  rol.getPermisosList();
//        for (Permisos permisosRegistrado1 : permisosRegistrado) {
//            if(!permisoSeleccionado.contains(permisosRegistrado1)){
//                permisoNoSeleccionado.add(permisosRegistrado1);
//            }  
//        }
        permisosRegistrado.removeAll(permisoSeleccionado);
        permisoNoSeleccionado.addAll(permisosRegistrado);
        model.addAttribute("permisoSeleccionado", permisoSeleccionado);
        model.addAttribute("permisoNoSeleccionado", permisoNoSeleccionado);
        return new ModelAndView("edit-rol", "editar-rol", rol);
    }
    
    @RequestMapping(value = "/permiso",method = RequestMethod.GET)
    public String vistaPermisos(){
        log.info("Ingreso al CRUD de Permiso");
        return "permiso";
    }

}
