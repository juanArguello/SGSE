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
<!--        <link rel="shortcut icon" href="<c:out value='recursos/images/logo.ico'/>"
              type="image/x-icon" />-->
        <link rel="icon" href="<c:out value='recursos/images/favicon.png'/>"
              type="image/x-icon" />
         <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" type="text/css" 
              href="https://cdn.datatables.net/v/dt/dt-1.11.2/datatables.min.css"/>
        <link rel="stylesheet" href="<c:out value='recursos/css/index-estilo.css'/>"
              type="text/css"  />
        <link rel="stylesheet" 
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"  />
        <title>Usuario</title>    
    </head>
    <body id="bodyUsuario">
        <jsp:include page="/WEB-INF/templates/header.jsp"/>
        <h1>Lista de Usuarios</h1>
        <div style="height: 40px"></div>
        <a id="btnNuevoUsuario" class="btn btn-success btn-sm bi bi-plus"
               data-toggle="modal"  data-whatever="@mdo">Agregar</a><br><br>
        <div class="container">
            <div class="table-responsive">
                <table id="tabla_usuarios" class="table table-bordered table-striped table-hover"
                       style="width:100%">
                    <thead class="thead-dark">
                        <th>ID</th>
                        <th>Cedula</th>
                        <th>RUC</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Dirección</th>
                        <th>Telefono</th>
                        <th>E-mail</th>
                        <th>Fecha de Ingreso</th>
                        <th>Estado</th>
                        <th>Nombre Usuario</th>
                        <th>Contraseña</th>
                        <th>Rol</th>
                        <th>Acciones</th>
                    </thead>
                    <tbody>
                             
                    </tbody>
                </table>
            </div>
        </div>

        <script src="<c:out value='recursos/js/usuario.js'/>"
        type="text/javascript"></script>
        <script src="<c:out value='recursos/js/global.js'/>"
        type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" 
        src="https://cdn.datatables.net/v/dt/dt-1.11.2/datatables.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <jsp:include page="/WEB-INF/templates/footer.jsp"/>
        
    </body>
</html>
