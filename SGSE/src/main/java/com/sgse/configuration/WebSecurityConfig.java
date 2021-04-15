/*
    Clase WebSecurityConfig permite autenticar usuario e interceptar peticiones HTTP
    de acuerdo al rol otorgado
 */
package com.sgse.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Juan Carlos Argüello Ortiz
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
   
    private static final String CONSULTA_POR_USUARIO = "select nombre_usuario as username,contrasenha as password,\n" +
        "	case estado\n" +
        "		when 'activo' then true\n" +
        "		else false end\n" +
        "from usuario where nombre_usuario = ?";

    private static final String CONSULTA_POR_ROL = "select nombre_usuario as username, rol.nombre as authority\n" +
        "from usuario, rol, rol_permisos \n" +
        "    where usuario.id_rol = rol_permisos.id_rol and \n" +
        "    rol_permisos.id_rol = rol.id and nombre_usuario=?";
    
    @Autowired
    private DataSource dataSource;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth); 
        auth
            .jdbcAuthentication()
                .dataSource(dataSource)
                .withDefaultSchema()
                .usersByUsernameQuery(CONSULTA_POR_USUARIO)
                .authoritiesByUsernameQuery(CONSULTA_POR_ROL)
            .passwordEncoder(new BCryptPasswordEncoder());        
    }

    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http); 
        http
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/index").hasAnyRole("ROLE_ADMIN","ROLE_VEND","ROLE_CONT","ROLE_AUDT")
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .loginProcessingUrl("/login")
                .usernameParameter("nombreUsuario")
                .passwordParameter("contrasenha")
                .and()
            .logout()
                .logoutSuccessUrl("/login")
                .logoutUrl("/logout")
                .and()
            .csrf()
                .and()
            .rememberMe()
                .key("claveApp");           
    }
    
}
