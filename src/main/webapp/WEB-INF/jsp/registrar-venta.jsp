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
        <!--  Datatables  -->
        <link rel="stylesheet" type="text/css"
              href="https://cdn.datatables.net/v/dt/dt-1.11.2/datatables.min.css"/>
        <!--  extension responsive  -->
        <link rel="stylesheet" type="text/css"
              href="https://cdn.datatables.net/responsive/2.2.9/css/responsive.dataTables.min.css"/>
        <!--  extension select  -->
        <link rel="stylesheet" type="text/css"
              href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css"/>
        <link rel="stylesheet" href="<c:out value='${pageContext.request.contextPath}/recursos/css/global-estilo.css'/>"
              type="text/css"  />
        <title>Ventas</title>  
        <style>
            .jumbotron{
                padding: 1rem 1rem;
                background-color: white;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="container mt-3 mb-4">
            <div class="jumbotron">
                <div class="row">
                    <div class="col-lg-12 col-xs-12">
                        <div class="card bg-info">
                            <div class="card-header text-center" >
                                <label class="font-weight-bold text-white">Vendedor <span id="username"><sec:authentication property="principal.username" /></span></label>
                            </div>
                        </div>
                        <div class="card mt-3">
                            <div class="card-header text-center" >
                                <div class="text-success">Datos del Cliente</div>
                            </div>
                            <div class="card-body">
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="inputCity">Nombres y Apellidos:</label>
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="nuevoNombreCliente" 
                                                   name="nuevoNombreCliente" placeholder="Nombres y Apellidos" 
                                                   required readonly="">
                                            <div class="input-group-append">
                                                <button id="buscar_cliente" class="btn btn-sm btn-success" 
                                                        type="button" > 
                                                    <i class="bi bi-search"></i> Clientes 
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="cedula">C.I. Nº:</label>
                                        <input type="text" class="form-control" id="cedula"
                                               placeholder="Nº de Cedula" width="7"
                                               required readonly="">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="cedula">RUC:</label>
                                        <input type="text" class="form-control" id="ruc"
                                               placeholder="RUC"
                                               readonly="">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="inputPassword4">Telefono:</label>
                                        <input type="tel" class="form-control" id="telefono"
                                               placeholder="Telefono" 
                                               required readonly="">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card mt-3">
                            <div class="card-header text-center" >
                                Seguros
                            </div>
                            <div class="card-body">
                                <div class="">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!--  modal de lista de permisos clientes  -->
        <div class="modal fade" id="listaClientesModal" tabindex="-1" 
            aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header bg-info">
                        <h4 class="modal-title text-white">Lista de Clientes</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="table-responsive">
                            <table id="tabla_lista_clientes" 
                                class="table table-bordered table-striped table-hover"
                                width="100%">
                                <thead>
                                    <th>CEDULA</th>
                                    <th>RUC</th>
                                    <th>NOMBRE</th>
                                    <th>APELLIDO</th>
                                    <th>TELEFONO</th>
                                </thead>
                                <tbody id="bodyModalClientes"></tbody>
                            </table>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        
        <!--  modal de lista de permisos clientes  -->
        <!--<div class="modal fade" id="listaClientesModal" tabindex="-1" 
            aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header bg-info">
                        <h5 class="modal-title text-white">Lista de Clientes</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <table id="tabla_lista_clientes" 
                            class="table table-bordered table-striped table-hover table-responsive"
                            width="100%">
                            <thead>
                                <th>CEDULA</th>
                                <th>RUC</th>
                                <th>NOMBRE y APELLIDO</th>
                                <th>TELEFONO</th>
                            </thead>
                            <tbody id="bodyModalClientes"></tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>-->
        
        <script src="<c:out value='${pageContext.request.contextPath}/recursos/js/registrar-venta.js'/>"
            type="text/javascript"></script>
        <!--   Datatables-->
        <script type="text/javascript" 
        src="https://cdn.datatables.net/v/dt/dt-1.11.2/datatables.min.js"></script> 
        <!-- extension responsive -->
        <script type="text/javascript" 
        src="https://cdn.datatables.net/responsive/2.2.9/js/dataTables.responsive.min.js"></script>
        <!-- extension select -->
        <script type="text/javascript" 
        src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>
    </body>
</html>
