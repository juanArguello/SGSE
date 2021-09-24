/*
    Servicio Rest de Salon para realizar CRUD con sus respectivos metodos HTTP
    y en formato Json
 */
package com.sgse.apirest.controller;

import com.sgse.entities.Salon;
import com.sgse.service.SalonService;
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
public class SalonRestController {
    
    @Autowired
    private SalonService salonService;
    
    @PostMapping(path = "/salones",consumes = "application/json")
    public ResponseEntity<?> crearSalon(@Valid @RequestBody Salon salon, BindingResult result) {
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
            salonService.create(salon); // crea el salon
        } catch (DataAccessException e) { // Envia una excepcion con el error de insert en la BBDD
            map.put("mensaje", "Error al realizar insert en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El Salon ha sido creado con éxito");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/salones",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Salon> getSalones() {
        return salonService.findAll();
    }
    
    @GetMapping(path = "/salones/{id}",produces = "application/json")
    public ResponseEntity<?> getSalonById(@PathVariable("id") String id) {
        Salon salon = null;
        Map<String,Object> map = new HashMap<>();
        try {
            salon = salonService.findById(Integer.valueOf(id));
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al realizar la consulta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(salon == null){ // Si no existe el salon con el id ingresado retorna 404
            map.put("mensaje", "El Salon ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(salon,HttpStatus.OK);
    }
    
    @PutMapping(path = "/salones/{id}",consumes = "application/json")
    public ResponseEntity<?> updateSalon(@Valid @RequestBody Salon salon, BindingResult result,
        @PathVariable("id") String id ) {
        Salon salonNuevo = salonService.findById(Integer.valueOf(id));
        Map<String,Object> map = new HashMap<>();
        
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        
        if(salonNuevo == null){ // comprueba si existe el salon con el id ingresado
            map.put("mensaje", "Error: no se pudo editar, el salon ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        
        try {
            salonNuevo.setLocalidad(salon.getLocalidad());
            salonNuevo.setDescripcion(salon.getDescripcion());
            salonNuevo.setFecha(salon.getFecha());
            salonNuevo.setHorario(salon.getHorario());
            salonService.update(salonNuevo);
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al actualizar el salon en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El Salón ha sido actualizado con éxito");
        return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
    }
   
    
    @DeleteMapping(path = "/salones/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSalon(@PathVariable("id") String id) {
        salonService.delete(Integer.valueOf(id)); // Elimina el salon de acuerdo al ID
    }
    
    
}
