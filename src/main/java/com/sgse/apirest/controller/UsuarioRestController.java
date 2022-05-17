/*
    Servicio Rest de Usuario para realizar CRUD con sus respectivos metodos HTTP
    y en formato Json
 */
package com.sgse.apirest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.sgse.entities.Usuario;
import com.sgse.mail.Contrasenha;
import com.sgse.resources.NombreServidor;
import com.sgse.service.MailService;
import com.sgse.service.UsuarioService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */

@RestController
@CrossOrigin(origins = {NombreServidor.DOMINIO_LOCAL})
@RequestMapping(value = "/apirest")
public class UsuarioRestController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private MailService mailService;
    
  
    @Secured("ROLE_ADMINISTRADOR")
    @PostMapping(path = "/usuarios",consumes = "application/json")
    public ResponseEntity<?> crearUsuario(@Valid @RequestBody Usuario usuario, BindingResult result) {
        Map<String,Object> map = new HashMap<>();
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        
        usuario.setFechaIngreso(new Date());
        usuario.setEstado("activo");
        Contrasenha contrasenha = new Contrasenha(); 
        String contrasenhaPlana = usuario.getContrasenha(); // Se obtiene la contraseña plana del usuario
        // Setear la contraseña cifrandolo con algoritmo bCryt
        usuario.setContrasenha(contrasenha.cifrarContrasenha(contrasenhaPlana));
        
        try {
            usuarioService.create(usuario); // crea el usuario
        } catch (DataAccessException e) { // Envia una excepcion con el error de insert en la BBDD
            map.put("mensaje", "Error al realizar insert en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        // enviar el email con el nombreUsuario y contraseña
        String texto = "<p>Bienvenido " + usuario.getNombre() + " " + usuario.getApellido() + "</p>"
            + "<p>al staff  de la empresa Futuro." + "</p>"+
            "<p>El nombre de su Usuario es: " + usuario.getNombreUsuario() + "</p>"+
            "<p>La contraseña es: " + contrasenhaPlana + "</p>";
        mailService.enviarEmail(usuario.getEmail(), "Registro de Usuario exitoso!", texto);
        
        map.put("mensaje", "El usuario ha sido creado con éxito");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
    
    @Secured("ROLE_ADMINISTRADOR")
    @GetMapping(path = "/usuarios",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getUsuarios() {
        return usuarioService.findAll();
    }
 
    @GetMapping(path = "/usuarios/{id}",produces = "application/json")
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") String id){
        Usuario usuario = null;
        Map<String,Object> map = new HashMap<>();
        try {
            usuario = usuarioService.findById(Integer.valueOf(id));
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al realizar la consulta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(usuario == null){ // Si no existe el usuario con el id ingresado retorna 404
            map.put("mensaje", "El usuario ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }
    
    
    @GetMapping(path = "/usuarios/username={nombreUsuario}",produces = "application/json")
    public ResponseEntity<?> getUsuarioByUsername(@PathVariable("nombreUsuario") String nombreUsuario) {
        Usuario usuario = null;
        Map<String,Object> map = new HashMap<>();
        
        try {
            usuario = usuarioService.findByUsername(nombreUsuario);
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al realizar la consulta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(usuario == null){ // Si no existe el usuario con el username ingresado retorna 404
            map.put("mensaje", "El nombre de usuario: "+nombreUsuario+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }
    
    @Secured("ROLE_ADMINISTRADOR")
    @PutMapping(path = "/usuarios/{id}",consumes = "application/json")
    public ResponseEntity<?> updateUsuario(@Valid @RequestBody Usuario usuario, BindingResult result,
        @PathVariable("id") String id) {
        Usuario user = usuarioService.findById(Integer.valueOf(id));
        Map<String,Object> map = new HashMap<>();
        
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        
        if(user == null){ // comprueba si existe el usuario con el id ingresado
            map.put("mensaje", "Error: no se pudo editar, el usuario ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        
        user.setApellido(usuario.getApellido());
        user.setNombre(usuario.getNombre());
        user.setCedula(usuario.getCedula());
        user.setRuc(usuario.getRuc());
        user.setEmail(usuario.getEmail());
        user.setDireccion(usuario.getDireccion());
        user.setTelefono(usuario.getTelefono());
        user.setEstado(usuario.getEstado());
        user.setNombreUsuario(usuario.getNombreUsuario());
        user.setContrasenha(usuario.getContrasenha());
        user.setFacturaList(usuario.getFacturaList());
        user.setContratoVentaList(usuario.getContratoVentaList());
        user.setRegistrarVentaList(usuario.getRegistrarVentaList());
        user.setIdRol(usuario.getIdRol());
        user.setIdEmpresa(usuario.getIdEmpresa());
        try {
            usuarioService.update(user);
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al actualizar el usuario en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El usuario ha sido actualizado con éxito");
        return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
    }
    
    @Secured("ROLE_ADMINISTRADOR")
    @DeleteMapping(path = "/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuario(@PathVariable("id") String id) {
        usuarioService.delete(Integer.valueOf(id)); // Elimina el usuario de acuerdo al ID
    }
    
    @Secured("ROLE_ADMINISTRADOR")
    @GetMapping(path = "/usuarios/cantidad",produces = "text/plain")
    @ResponseStatus(HttpStatus.OK)
    public int cantidadUsuarios() {
        return usuarioService.cantidadFilas();
    }
    
}
