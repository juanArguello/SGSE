/*
    
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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import com.sgse.entities.Usuario;
import com.sgse.service.UsuarioService;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api")
public class UsuarioRestController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping(value = "/usuario")
    public List<Usuario> listarUsuarios() {
        return usuarioService.findAll();
    }
    
    @GetMapping("usuario/{id}")
    public Usuario get(@PathVariable String id) {
        return usuarioService.findById(Integer.valueOf(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
}
