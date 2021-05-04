/*
    Servicio Rest de Contrato Venta para realizar CRUD con sus respectivos metodos HTTP
    y en formato Json
 */
package com.sgse.apirest.controller;

import com.sgse.entities.ContratoVenta;
import com.sgse.service.ContratoVentaService;
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
public class ContratoVentaRestController {
    
    @Autowired
    private ContratoVentaService contratoVentaService;
        
    @PostMapping(path = "/contratoventas",consumes = "application/json")
    public ResponseEntity<?> crearContratoVenta(@Valid @RequestBody ContratoVenta contratoVenta, BindingResult result) {
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
            contratoVentaService.create(contratoVenta); // crea un contrato de venta
        } catch (DataAccessException e) { // Envia una excepcion con el error de insert en la BBDD
            map.put("mensaje", "Error al realizar insert en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El Contrato de venta ha sido creado con éxito");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/contratoventas",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ContratoVenta> getContratoVentas() {
        return contratoVentaService.findAll();
    }
    
    @GetMapping(path = "/contratoventas/{id}",produces = "application/json")
    public ResponseEntity<?> getContratoVentaById(@PathVariable("id") String id) {
        ContratoVenta contratoVenta = null;
        Map<String,Object> map = new HashMap<>();
        try {
            contratoVenta = contratoVentaService.findById(Integer.valueOf(id));
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al realizar la consulta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(contratoVenta == null){ // Si no existe el contrato de venta con el id ingresado retorna 404
            map.put("mensaje", "El Contrato de Venta ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contratoVenta,HttpStatus.OK);
    }
    
    @PutMapping(path = "/contratoventas/{id}",consumes = "application/json")
    public ResponseEntity<?> updateContratoVenta(@Valid @RequestBody ContratoVenta contratoVenta, BindingResult result,
        @PathVariable("id") String id ) {
        ContratoVenta contratoVentaNuevo = contratoVentaService.findById(Integer.valueOf(id));
        Map<String,Object> map = new HashMap<>();
        
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        
        if(contratoVentaNuevo == null){ // comprueba si existe el contrato de venta con el id ingresado
            map.put("mensaje", "Error: no se pudo editar, el contrato de venta ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        
        try {
            contratoVentaNuevo.setCedula(contratoVenta.getCedula());
            contratoVentaNuevo.setNombreCliente(contratoVenta.getNombreCliente());
            contratoVentaNuevo.setFecha(contratoVenta.getFecha());
            contratoVentaNuevo.setPaqueteSeguro(contratoVenta.getPaqueteSeguro());
            contratoVentaNuevo.setCosto(contratoVenta.getCosto());
            contratoVentaNuevo.setTipoPago(contratoVenta.getTipoPago());
            contratoVentaNuevo.setObservacion(contratoVenta.getObservacion());
            contratoVentaNuevo.setModoPago(contratoVenta.getModoPago());
            contratoVentaNuevo.setTipoServicio(contratoVenta.getTipoServicio());
            contratoVentaNuevo.setIdUsuario(contratoVenta.getIdUsuario());
            contratoVentaService.update(contratoVentaNuevo);
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al actualizar el contrato de venta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El Contrato de Venta ha sido actualizado con éxito");
        return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/contratoventas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContratoVenta(@PathVariable("id") String id) {
        contratoVentaService.delete(Integer.valueOf(id)); // Elimina el Contrato de Venta de acuerdo al ID
    }
    
}
