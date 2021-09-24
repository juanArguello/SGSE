/*
    Servicio Rest de Factura para realizar CRUD con sus respectivos metodos HTTP
    y en formato Json
 */
package com.sgse.apirest.controller;

import com.sgse.entities.Factura;
import com.sgse.service.FacturaService;
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
@RequestMapping(value = "/apirest")
public class FacturaRestController {
    
    @Autowired
    private FacturaService facturaService;
       
    @PostMapping(path = "/facturas",consumes = "application/json")
    public ResponseEntity<?> crearFactura(@Valid @RequestBody Factura factura, BindingResult result) {
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
            facturaService.create(factura); // crea la factura
        } catch (DataAccessException e) { // Envia una excepcion con el error de insert en la BBDD
            map.put("mensaje", "Error al realizar insert en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "La factura ha sido creado con éxito");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/facturas",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Factura> getFacturas() {
        return facturaService.findAll();
    }
    
    @GetMapping(path = "/facturas/{id}",produces = "application/json")
    public ResponseEntity<?> getFacturaById(@PathVariable("id") String id) {
        Factura factura = null;
        Map<String,Object> map = new HashMap<>();
        try {
            factura = facturaService.findById(Integer.valueOf(id));
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al realizar la consulta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(factura == null){ // Si no existe la factura con el id ingresado retorna 404
            map.put("mensaje", "La Factura ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(factura,HttpStatus.OK);
    }
    
    @PutMapping(path = "/facturas/{id}",consumes = "application/json")
    public ResponseEntity<?> updateFactura(@Valid @RequestBody Factura factura, BindingResult result,
        @PathVariable("id") String id ) {
        Factura facturaNueva = facturaService.findById(Integer.valueOf(id));
        Map<String,Object> map = new HashMap<>();
        
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        
        if(facturaNueva == null){ // comprueba si existe la factura con el id ingresado
            map.put("mensaje", "Error: no se pudo editar, la factura ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        
        try {
            facturaNueva.setNombreEmisor(factura.getNombreEmisor());
            facturaNueva.setNroFactura(factura.getNroFactura());
            facturaNueva.setNroTimbrado(factura.getNroTimbrado());
            facturaNueva.setFechaLimieValidez(factura.getFechaLimieValidez());
            facturaNueva.setNumeracion(factura.getNumeracion());
            facturaNueva.setFechaFactura(factura.getFechaFactura());
            facturaNueva.setNombreCliente(factura.getNombreCliente());
            facturaNueva.setDireccion(factura.getDireccion());
            facturaNueva.setTipoPago(factura.getTipoPago());
            facturaNueva.setTelefono(factura.getTelefono());
            facturaNueva.setRucCiCliente(factura.getRucCiCliente());
            facturaNueva.setPrecioUnitario(factura.getPrecioUnitario());
            facturaNueva.setValorIva(factura.getValorIva());
            facturaNueva.setCantidad(factura.getCantidad());
            facturaNueva.setCostoTotal(factura.getCostoTotal());
            facturaNueva.setDescripcion(factura.getDescripcion());
            facturaNueva.setLiquidacionIva(factura.getLiquidacionIva());
            facturaService.update(facturaNueva);
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al actualizar la factura en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "La Factura ha sido actualizado con éxito");
        return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
    }
 
    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFactura(@PathVariable("id") String id) {
        facturaService.delete(Integer.valueOf(id)); // Elimina la factura de acuerdo al ID
    }
    
}
