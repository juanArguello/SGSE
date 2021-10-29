<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes"/>
        <meta name="robots" content="ALL" />
        <meta name="description" content="Futuro Servicios Exequiales" />
        <meta name="keywords" content="Futuro,Funeraria,Seguro Exequiales, Servicios Exequiales" />
        <link rel="shortcut icon" href="<c:out value='${pageContext.request.contextPath}/recursos/images/logo.ico'/>"
              type="image/x-icon" />
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="<c:out value='${pageContext.request.contextPath}/recursos/css/index-estilo.css'/>"
              type="text/css"  />
        <title>Administración</title>    
    </head>
    <body id="bodyAdmin">
        <jsp:include page="header.jsp"/>
        <div style="height: 50px;" ></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title text-center">Panel Administrativo</h4>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-4 mb-4">
                                    <a href="/administracion/usuario" class="card bg-primary text-white h-100 ">
                                        <div class="card-body py-5">
                                            <h4>Usuarios</h4>
                                            <h2 class="justify-content-start">
                                                <i class="bi bi-people-fill"></i>
                                            </h2>
                                            <p class="m-b-0 text-right">
                                                <span class="h2">
                                                    <c:out value="${cantidadUsuario}"/>
                                                </span>
                                                registrado
                                            </p>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-4 mb-4">
                                    <a href="/administracion/roles" class="card bg-success text-white h-100">
                                        <div class="card-body py-5">
                                            <h4>Roles</h4>                                               
                                            <h2 class="justify-content-start">
                                                <i class="bi bi-shield-lock-fill"></i>
                                            </h2>
                                            <p class="m-b-0 text-right">
                                                <span class="h2">
                                                    <c:out value="${cantidadRol}"/>
                                                </span>
                                                registrado
                                            </p>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-md-4 mb-4">
                                    <a href="/administracion/permiso" class="card bg-danger text-white h-100">
                                        <div class="card-body py-5 ">
                                            <h4>Permisos</h4>                                               
                                            <h2 class="justify-content-start">
                                                <i class="bi bi-lock-fill"></i>
                                            </h2>
                                            <p class="m-b-0 text-right">
                                                <span class="h2">
                                                    <c:out value="${cantidadPermiso}"/>
                                                </span>
                                                registrado
                                            </p>
                                        </div>
                                    </a>
                                </div>
                            <div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
