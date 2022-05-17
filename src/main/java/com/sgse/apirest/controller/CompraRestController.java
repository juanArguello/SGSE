/*
    Servicio Rest de Compra para realizar CRUD con sus respectivos metodos HTTP
    y en formato Json
 */
package com.sgse.apirest.controller;

import com.sgse.entities.Compra;
import com.sgse.resources.NombreServidor;
import com.sgse.service.CompraService;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = {NombreServidor.DOMINIO_LOCAL})
@RequestMapping("/apirest")
public class CompraRestController {
    
    @Autowired
    private CompraService compraService;
    
    @PostMapping(path = "/compras",consumes = "application/json")
    public ResponseEntity<?> crearCompra(@Valid @RequestBody Compra compra, BindingResult result) {
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
            compraService.create(compra); // crea la compra
        } catch (DataAccessException e) { // Envia una excepcion con el error de insert en la BBDD
            map.put("mensaje", "Error al realizar insert en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "La Compra ha sido creado con éxito");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/compras",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Compra> getCompras() {
        return compraService.findAll();
    }
    
    @GetMapping(path = "/compras/{id}",produces = "application/json")
    public ResponseEntity<?> getCompraById(@PathVariable("id") String id) {
        Compra compra = null;
        Map<String,Object> map = new HashMap<>();
        try {
            compra = compraService.findById(Integer.valueOf(id));
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al realizar la consulta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(compra == null){ // Si no existe la compra con el id ingresado retorna 404
            map.put("mensaje", "La Compra ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(compra,HttpStatus.OK);
    }
    
    @PutMapping(path = "/compras/{id}",consumes = "application/json")
    public ResponseEntity<?> updateCompra(@Valid @RequestBody Compra compra, BindingResult result,
        @PathVariable("id") String id ) {
        Compra compraNuevo = compraService.findById(Integer.valueOf(id));
        Map<String,Object> map = new HashMap<>();
        
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        
        if(compraNuevo == null){ // comprueba si existe la compra con el id ingresado
            map.put("mensaje", "Error: no se pudo editar, la compra ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        
        try {
            compraNuevo.setFecha(compra.getFecha());
            compraNuevo.setMonto(compra.getMonto());
            compraNuevo.setSeguro(compra.getSeguro());
            compraNuevo.setCliente(compra.getCliente());
            compraService.update(compraNuevo);
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al actualizar la compra en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "La Compra ha sido actualizado con éxito");
        return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
    }
   
    
    @DeleteMapping(path = "/compras/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompra(@PathVariable("id") String id) {
        compraService.delete(Integer.valueOf(id)); // Elimina la compra de acuerdo al ID
    }
    
}
