/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.config.custom;

import com.sgse.entities.Permisos;
import com.sgse.entities.Usuario;
import com.sgse.service.UsuarioService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Juan Carlos Arguello Ortiz
 */
//@Component(value = "customPermissionEvaluator")
public class CustomPermissionEvaluator implements PermissionEvaluator {
    
    @Autowired
    private UsuarioService usuarioService;
    
    private Usuario usuario;
    
   
    
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if ((authentication == null) || (targetDomainObject == null) || !(permission instanceof String)) {
            return false;
        }
        //String targetType = targetDomainObject.getClass().getSimpleName().toUpperCase();
        //return hasPermisos(auth, targetType, permission.toString().toUpperCase());
        String targetType = targetDomainObject.getClass().getSimpleName();
        return checkPermission(authentication, permission.toString());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, 
        Object permission) {
        if ((authentication == null) || (targetType == null) || !(permission instanceof String)) {
            return false;
        }
        //return hasPermisos(auth, targetType.toUpperCase(), permission.toString().toUpperCase());
        return checkPermission(authentication, permission.toString());
    }

    private boolean checkPermission(Authentication authentication, String permission) {
        //return usuario.getIdRol().getPermisosList().stream().anyMatch((permisos) -> (permisos.getNombre().equals(permission)));
        List<Permisos> permisosList = getPermisosByUsername(authentication);
        return permisosList.stream().anyMatch((permiso) -> (permiso.getNombre().toUpperCase().equals(permission.toUpperCase())));
    }   

    private List<Permisos> getPermisosByUsername(Authentication authentication) {
        usuario = usuarioService.findByUsername(authentication.getName());
        return usuario.getIdRol().getPermisosList();
		
    }
}
