/*
    Servicio Rest de Inventario para realizar CRUD con sus respectivos metodos HTTP
    y en formato Json
 */
package com.sgse.apirest.controller;

import com.sgse.entities.Inventario;
import com.sgse.service.InventarioService;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = {"https://localhost:8443"})
@RequestMapping("/apirest")
public class InventarioRestController {
    
    @Autowired
    private InventarioService inventarioService;
    
    @PostMapping(path = "/inventarios",consumes = "application/json")
    public ResponseEntity<?> crearInventario(@Valid @RequestBody Inventario inventario, BindingResult result) {
        Map<String,Object> map = new HashMap<>();
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
       
        try {
            inventarioService.create(inventario); // crea el inventario
        } catch (DataAccessException e) { // Envia una excepcion con el error de insert en la BBDD
            map.put("mensaje", "Error al realizar insert en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El Inventario ha sido creado con éxito");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/inventarios",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Inventario> getInventarios() {
        return inventarioService.findAll();
    }
    
    @GetMapping(path = "/inventarios/{id}",produces = "application/json")
    public ResponseEntity<?> getInventarioById(@PathVariable("id") String id) {
        Inventario inventario = null;
        Map<String,Object> map = new HashMap<>();
        try {
            inventario = inventarioService.findById(Integer.valueOf(id));
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al realizar la consulta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(inventario == null){ // Si no existe el Inventario con el id ingresado retorna 404
            map.put("mensaje", "El Inventario ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventario,HttpStatus.OK);
    }
    
    @PutMapping(path = "/inventarios/{id}",consumes = "application/json")
    public ResponseEntity<?> updateInventario(@Valid @RequestBody Inventario inventario, BindingResult result,
        @PathVariable("id") String id ) {
        Inventario inventarioNuevo = inventarioService.findById(Integer.valueOf(id));
        Map<String,Object> map = new HashMap<>();
        
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        
        if(inventarioNuevo == null){ // comprueba si existe el inventario con el id ingresado
            map.put("mensaje", "Error: no se pudo editar, el Inventario ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        
        try {
            inventarioNuevo.setCosto(inventario.getCosto());
            inventarioNuevo.setCantidad(inventario.getCantidad());
            inventarioNuevo.setTipoServicio(inventario.getTipoServicio());
            inventarioNuevo.setFecha(inventario.getFecha());
            inventarioNuevo.setComprobante(inventario.getComprobante());
            inventarioNuevo.setDescripcion(inventario.getDescripcion());
            inventarioService.update(inventarioNuevo);
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al actualizar el Inventario en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El Inventario ha sido actualizado con éxito");
        return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
    }
   
    
    @DeleteMapping(path = "/inventarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRol(@PathVariable("id") String id) {
        inventarioService.delete(Integer.valueOf(id)); // Elimina el inventario de acuerdo al ID
    }
    
}
