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
<!--        <link rel="shortcut icon" href="<c:out value='${pageContext.request.contextPath}/recursos/images/logo.ico'/>"
              type="image/x-icon" />-->
        <link rel="icon" href="<c:out value='/recursos/images/favicon.png'/>"
              type="image/x-icon" />
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="<c:out value='recursos/css/index-estilo.css'/>"
              type="text/css"  />
        <link rel="stylesheet" 
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"  />
        <title>Administración</title>    
    </head>
    <body id="bodyAdmin">
        <jsp:include page="/WEB-INF/templates/header.jsp"/>
        <div style="height: 50px;" ></div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4>Panel Administrativo</h4>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 mb-3">
                    <div class="card bg-primary text-white h-100 ">
                        <div class="card-body py-5">
                            <h4>Usuarios</h4>
                            <h2 class="justify-content-start">
                                <i class="fa fa-users f-left"></i>
                            </h2>
                            <p class="m-b-0 text-right">
                                <span class="h2">
                                    <c:out value="${cantidadUsuario}"/>
                                </span>
                            </p>
                        </div>
                        <div class="card-footer d-flex">
                            <a href="/usuario" class="text-white">Ver más</a>
                            <span class="ms-auto">
                                <i class="bi bi-chevron-right"></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card bg-success text-white h-100">
                        <div class="card-body py-5">
                            <h4>Roles</h4>                                               
                            <h2 class="justify-content-start">
                                <i class="fa fa-user-lock f-left"></i>
                            </h2>
                            <p class="m-b-0 text-right">
                                <span class="h2">
                                    <c:out value="${cantidadRol}"/>
                                </span>
                            </p>
                        </div>
                        <div class="card-footer d-flex">
                            <a href="/roles" class="text-white">Ver más</a>
                            <span class="ms-auto">
                                <i class="bi bi-chevron-right"></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <div class="card bg-danger text-white h-100">
                        <div class="card-body py-5 ">
                            <h4>Permisos</h4>                                               
                            <h2 class="justify-content-start">
                                <i class="bi bi-lock-fill"></i>
                            </h2>
                            <p class="m-b-0 text-right">
                                <span class="h2">
                                    <c:out value="${cantidadPermiso}"/>
                                </span>
                            </p>
                        </div>
                        <div class="card-footer d-flex">
                            <a href="/permiso" class="text-white">Ver más</a>
                            <span class="ms-auto">
                                <i class="bi bi-chevron-right"></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="<c:out value='recursos/js/global.js'/>"
        type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
        <jsp:include page="/WEB-INF/templates/footer.jsp"/>
    </body>
</html>
