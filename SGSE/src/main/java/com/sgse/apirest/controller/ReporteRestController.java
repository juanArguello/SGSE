/*
    Servicio Rest de Reporte para realizar CRUD con sus respectivos metodos HTTP
    y en formato Json
 */
package com.sgse.apirest.controller;

import com.sgse.entities.Reporte;
import com.sgse.service.ReporteService;
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
public class ReporteRestController {
    
    @Autowired
    private ReporteService reporteService;
    
    @PostMapping(path = "/reportes",consumes = "application/json")
    public ResponseEntity<?> crearReporte(@Valid @RequestBody Reporte reporte, BindingResult result) {
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
            reporteService.create(reporte); // crea el reporte
        } catch (DataAccessException e) { // Envia una excepcion con el error de insert en la BBDD
            map.put("mensaje", "Error al realizar insert en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El Reporte ha sido creado con éxito");
        return new ResponseEntity<>(map,HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/reportes",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Reporte> getReportes() {
        return reporteService.findAll();
    }
    
    @GetMapping(path = "/reportes/{id}",produces = "application/json")
    public ResponseEntity<?> getReporteById(@PathVariable("id") String id) {
        Reporte reporte = null;
        Map<String,Object> map = new HashMap<>();
        try {
            reporte = reporteService.findById(Integer.valueOf(id));
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al realizar la consulta en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(reporte == null){ // Si no existe el reporte con el id ingresado retorna 404
            map.put("mensaje", "El Reporte ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reporte,HttpStatus.OK);
    }
    
    @PutMapping(path = "/reportes/{id}",consumes = "application/json")
    public ResponseEntity<?> updateReporte(@Valid @RequestBody Reporte reporte, BindingResult result,
        @PathVariable("id") String id ) {
        Reporte reporteNuevo = reporteService.findById(Integer.valueOf(id));
        Map<String,Object> map = new HashMap<>();
        
        if(result.hasErrors()){ // verifica si hay errores en los campos de datos JSON
            List<String> errores = new ArrayList<>();
            result.getFieldErrors().forEach((err) -> {
                errores.add("El campo '"+err.getField()+ "' "+err.getDefaultMessage());
            });
            map.put("errores", errores);
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        
        if(reporteNuevo == null){ // comprueba si existe el reporte con el id ingresado
            map.put("mensaje", "Error: no se pudo editar, el reporte ID: "+id+" no existe en la base de datos");
            return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
        }
        
        try {
            reporteNuevo.setDescripcion(reporte.getDescripcion());
            reporteNuevo.setTipoSeguro(reporte.getTipoSeguro());
            reporteNuevo.setTipoServicio(reporte.getTipoServicio());
            reporteNuevo.setObservacion(reporte.getObservacion());
            reporteService.update(reporteNuevo);
        } catch (DataAccessException e) {
            map.put("mensaje", "Error al actualizar el reporte en la base de datos");
            map.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        map.put("mensaje", "El Reporte ha sido actualizado con éxito");
        return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
    }
   
    
    @DeleteMapping(path = "/reportes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReporte(@PathVariable("id") String id) {
        reporteService.delete(Integer.valueOf(id)); // Elimina el reporte de acuerdo al ID
    }
    
}
