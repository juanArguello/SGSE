/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.config.custom;

import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;

/**
 *
 * @author user
 */
public class MySecurityExpressionRoot extends SecurityExpressionRoot{
   
    public MySecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }
   
}
