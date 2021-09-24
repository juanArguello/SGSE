/*
    Servicio Rest de Seguro para realizar CRUD con sus respectivos metodos HTTP
    y en formato Json
 */
package com.sgse.apirest.controller;

import com.sgse.entities.Seguro;
import com.sgse.service.SeguroService;
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
public class SeguroRestController {
    
    @Autowired
    private SeguroService seguroService;
    
    @PostMapping(path = "/seguros",consumes = "application/json")
    public ResponseEntity<?> crearSeguro(@Valid @RequestBody Seguro seguro, BindingResult result) {
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
            seguroService.create(seguro); // crea el seguro
        } catch (DataAccessException e) { // Envia una excepcion con el error de insert en la BBDD
            map.put("mensaje", "Error al realizar insert en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El Seguro ha sido creado con éxito");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/seguros",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Seguro> getSeguros() {
        return seguroService.findAll();
    }
    
    @GetMapping(path = "/seguros/{id}",produces = "application/json")
    public ResponseEntity<?> getSeguroById(@PathVariable("id") String id) {
        Seguro seguro = null;
        Map<String,Object> map = new HashMap<>();
        try {
            seguro = seguroService.findById(Integer.valueOf(id));
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al realizar la consulta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(seguro == null){ // Si no existe el seguro con el id ingresado retorna 404
            map.put("mensaje", "El Seguro ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(seguro,HttpStatus.OK);
    }
    
    @PutMapping(path = "/seguros/{id}",consumes = "application/json")
    public ResponseEntity<?> updateSeguro(@Valid @RequestBody Seguro seguro, BindingResult result,
        @PathVariable("id") String id) {
        Seguro seguroNuevo = seguroService.findById(Integer.valueOf(id));
        Map<String,Object> map = new HashMap<>();
        
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        
        if(seguroNuevo == null){ // comprueba si existe el seguro con el id ingresado
            map.put("mensaje", "Error: no se pudo editar, el seguro ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        
        try {
            seguroNuevo.setPaqueteServicio(seguro.getPaqueteServicio());
            seguroNuevo.setPrecio(seguro.getPrecio());
            seguroNuevo.setIva(seguro.getIva());
            seguroNuevo.setTipoServicio(seguro.getTipoServicio());
            seguroNuevo.setDescripcion(seguro.getDescripcion());
            seguroService.update(seguroNuevo);
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al actualizar el seguro en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El Seguro ha sido actualizado con éxito");
        return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping(path = "/seguros/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSeguro(@PathVariable("id") String id) {
        seguroService.delete(Integer.valueOf(id));
    }
    
}
