/*
    Servicio Rest de RegistrarVenta para realizar CRUD con sus respectivos metodos HTTP
    y en formato Json
 */
package com.sgse.apirest.controller;

import com.sgse.entities.RegistrarVenta;
import com.sgse.service.RegistrarVentaService;
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
public class RegistrarVentaRestController {
    
    @Autowired
    private RegistrarVentaService registrarVentaService;
    
    @PostMapping(path = "/registrarventas",consumes = "application/json")
    public ResponseEntity<?> crearRegistroVenta(@Valid @RequestBody RegistrarVenta registrarVenta, BindingResult result) {
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
            registrarVentaService.create(registrarVenta); // crea el registro Ventas
        } catch (DataAccessException e) { // Envia una excepcion con el error de insert en la BBDD
            map.put("mensaje", "Error al realizar insert en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El registro Ventas ha sido creado con éxito");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/registrarventas",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<RegistrarVenta> getRegistrarVentas() {
        return registrarVentaService.findAll();
    }
    
    @GetMapping(path = "/registrarventas/{id}",produces = "application/json")
    public ResponseEntity<?> getRegistrarVentaById(@PathVariable("id") String id) {
        RegistrarVenta registrarVenta = null;
        Map<String,Object> map = new HashMap<>();
        try {
            registrarVenta = registrarVentaService.findById(Integer.valueOf(id));
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al realizar la consulta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(registrarVenta == null){ // Si no existe el registro Venta con el id ingresado retorna 404
            map.put("mensaje", "El registro Venta ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(registrarVenta,HttpStatus.OK);
    }
    
    @PutMapping(path = "/registrarVentas/{id}",consumes = "application/json")
    public ResponseEntity<?> updateRegistrarVenta(@Valid @RequestBody RegistrarVenta registrarVenta, 
        BindingResult result, @PathVariable("id") String id ) {
        RegistrarVenta registrarVentaNuevo = registrarVentaService.findById(Integer.valueOf(id));
        Map<String,Object> map = new HashMap<>();
        
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        
        if(registrarVentaNuevo == null){ // comprueba si existe el registrarVenta con el id ingresado
            map.put("mensaje", "Error: no se pudo editar, el registrarVenta ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        
        try {
            registrarVentaNuevo.setFecha(registrarVenta.getFecha());
            registrarVentaNuevo.setMonto(registrarVenta.getMonto());
            registrarVentaNuevo.setTipoVenta(registrarVenta.getTipoVenta());
            registrarVentaService.update(registrarVentaNuevo);
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al actualizar el registrarVenta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El registrarVenta ha sido actualizado con éxito");
        return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
    }
   
    
    @DeleteMapping(path = "/registrarVentas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRegistrarVenta(@PathVariable("id") String id) {
        registrarVentaService.delete(Integer.valueOf(id)); // Elimina el registrarVenta de acuerdo al ID
    }
    
}
