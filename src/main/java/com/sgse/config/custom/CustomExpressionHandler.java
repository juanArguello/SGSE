/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgse.config.custom;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

/**
 *
 * @author user
 */
public class CustomExpressionHandler extends DefaultMethodSecurityExpressionHandler{
    
    private final AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
    
    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(
			Authentication authentication, MethodInvocation invocation) {
      
        /*MethodSecurityExpressionRoot root = new MethodSecurityExpressionRoot(
				authentication);*/
        final MySecurityExpressionRoot root = new MySecurityExpressionRoot(authentication);
        root.setPermissionEvaluator(new CustomPermissionEvaluator());
		root.setTrustResolver(this.trustResolver);
		root.setRoleHierarchy(getRoleHierarchy());
		root.setDefaultRolePrefix(getDefaultRolePrefix());
        return (MethodSecurityExpressionOperations) root;
	}
}
