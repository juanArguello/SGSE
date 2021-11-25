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
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
        <!-- Bootstrap icons -->
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <!--  Datatables  -->
        <link rel="stylesheet" type="text/css" 
              href="https://cdn.datatables.net/v/dt/dt-1.11.2/datatables.min.css"/>
        <!--  extension responsive  -->
        <link rel="stylesheet" type="text/css"
              href="https://cdn.datatables.net/responsive/2.2.9/css/responsive.dataTables.min.css"/>
        <!--  extension select  -->
        <link rel="stylesheet" type="text/css"
              href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css"/>
        <link rel="stylesheet" href="<c:out value='${pageContext.request.contextPath}/recursos/css/index-estilo.css'/>"
              type="text/css"  />
        <title>Usuario</title>    
    </head>
    <body id="bodyUsuario">
        <jsp:include page="header.jsp"/>
        <div style="height: 20px"></div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 mb-3">
                    <div class="card">
                        <div class="card-header">
                            <h5 class="card-title">
                                <i class="bi bi-table me-2"></i> Lista de Usuarios
                            </h5> 
                        </div>
                        <div style="height: 10px;"></div>
                        <div class="col-lg-3">
                            <a id="btnNuevoUsuario" href="<c:out value='${pageContext.request.contextPath}/administracion/usuario/add'/>"
                               class="btn btn-primary btn-sm bi bi-person-plus-fill"> Agregar</a><br><br>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table id="tabla_usuarios" 
                                       class="table table-bordered table-striped table-hover display responsive  nowrap"
                                       width="100%">
                                    <thead class="thead-dark">
                                    <th>ID</th>
                                    <th>Cedula</th>
                                    <th>RUC</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Nombre Usuario</th>
                                    <th>Estado</th>
                                    <th>Fecha de Ingreso</th>
                                    <th>E-mail</th>
                                    <th>Acciones</th>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--  Modal para visualizar datos detallado del usuario -->
        <div class="modal fade" id="modal-usuario-detalle" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel" aria-hidden="true" >
            <div class="modal-dialog modal-dialog-scrollable modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header bg-info">
                        <h5 class="modal-title text-white" id="tituloUser" style="align-content: center"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <table id="tabla_user" 
                            class="table table-bordered table-striped table-hover table-responsive"
                            width="100%">
                            <tbody id="bodyModalUsuario"></tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div> 

        <script src="<c:out value='${pageContext.request.contextPath}/recursos/js/usuario.js'/>"
        type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
        <!--   Datatables-->
        <script type="text/javascript" 
        src="https://cdn.datatables.net/v/dt/dt-1.11.2/datatables.min.js"></script>
        <!-- extension responsive -->
        <script type="text/javascript" 
        src="https://cdn.datatables.net/responsive/2.2.9/js/dataTables.responsive.min.js"></script>
        <!--  SweetAlert  -->
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <!-- extension select -->
        <script type="text/javascript" 
        src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>
    </body>
</html>
