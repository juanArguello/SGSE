![Futuro Logo](src/main/webapp/recursos/images/sgse.png)
# SGSE - Sistema de Gestion de Ventas Seguros 
El Sistema SGSE es un sistema web responsive para la gestion de ventas y facturacion de seguros  
exequiales para la empresa Futuro, sus principales funciones son:  
> Registrar, editar, borrar y visualizar Usuarios, Roles y permisos.  
> Registrar ventas de seguros.  
> Registrar datos del cliente.  
> Emisión de facturas por cada transacción comercial realizada.  

## Recursos implementado en el sistema

El sistema SGSE es un proyecto MVC utiliza el gestor de contrucción y dependencia [Maven](https://maven.apache.org/), en el back-end  
utiliza el lenguaje Java versión 8 y el framework [Spring](https://github.com/spring-projects/spring-framework/tree/5.2.x) versión 5.2.13.RELEASE. El servidor de base de datos es  
[PostgreSQL](https://www.postgresql.org/) y el servidor de aplicación es [Apache Tomcat](http://tomcat.apache.org/).  
En el Front-End utiliza java server page JSP y la libreria JSTL, jQuery, y [Bootstrap](https://getbootstrap.com/) versión 4.6.  
Los archivos JSP son mapeados a vistas simples en el descriptor de lenguaje [Web.xml](src/main/webapp/WEB-INF/web.xml).  

## Construcción del proyecto

Ejecute el comando `mvn clean` para limpiar el proyecto. Despues ejecute `mvn install` para construir el empaquetado  
WAR en el repositorio local.
  
  
  
Proyecto del codigo fuente alojado en **GitHub**