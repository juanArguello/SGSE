/*
    Servicio Rest de Sucursal para realizar CRUD con sus respectivos metodos HTTP
    y en formato Json
 */
package com.sgse.apirest.controller;

import com.sgse.entities.Sucursal;
import com.sgse.resources.NombreServidor;
import com.sgse.service.SucursalService;
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
@CrossOrigin(origins = {NombreServidor.DOMINIO_LOCAL})
@RequestMapping("/apirest")
public class SucursalRestController {
     
    @Autowired
    private SucursalService sucursalService;
    
    @PostMapping(path = "/sucursales",consumes = "application/json")
    public ResponseEntity<?> crearSucursal(@Valid @RequestBody Sucursal sucursal, BindingResult result) {
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
            sucursalService.create(sucursal); // crea una sucursal de la empresa
        } catch (DataAccessException e) { // Envia una excepcion con el error de insert en la BBDD
            map.put("mensaje", "Error al realizar insert en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "La sucursal ha sido creado con éxito");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/sucursales",produces ="application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Sucursal> getSucursales() {
        return sucursalService.findAll();
    }
    
    @GetMapping(path = "/sucursales/{id}",produces ="application/json")
    public ResponseEntity<?> getSucursalById(@PathVariable("id") String id) {
        Sucursal sucursal = null;
        Map<String,Object> map = new HashMap<>();
        try {
            sucursal = sucursalService.findById(Integer.valueOf(id));
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al realizar la consulta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(sucursal == null){ // Si no existe la sucursal con el id ingresado retorna 404
            map.put("mensaje", "La sucursal ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sucursal,HttpStatus.OK);
    }
    
    @PutMapping(path = "/sucursales/{id}",consumes = "application/json")
    public ResponseEntity<?> updateSucursal(@Valid @RequestBody Sucursal sucursal, BindingResult result,
        @PathVariable("id") String id) {
        Sucursal sucursalNuevo = sucursalService.findById(Integer.valueOf(id));
        Map<String,Object> map = new HashMap<>();
        
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        
        if(sucursalNuevo == null){ // comprueba si existe la sucursal con el id ingresado
            map.put("mensaje", "Error: no se pudo editar, la sucursal ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        
        try {
            sucursalNuevo.setDireccion(sucursal.getDireccion());
            sucursalNuevo.setLocalidad(sucursal.getLocalidad());
            sucursalNuevo.setTelefono(sucursal.getTelefono());
            sucursalNuevo.setEstado(sucursal.getEstado());
            sucursalService.update(sucursalNuevo);
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al actualizar la sucursal en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "La Sucursal ha sido actualizado con éxito");
        return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
    }
   
    @DeleteMapping(path = "/sucursales/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        sucursalService.delete(Integer.valueOf(id));
    }
    
}
