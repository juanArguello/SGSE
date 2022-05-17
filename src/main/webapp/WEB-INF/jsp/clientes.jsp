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
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <!-- Bootstrap icons -->
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <!--  Datatables  -->
        <link rel="stylesheet" type="text/css"
              href="https://cdn.datatables.net/v/dt/dt-1.11.2/datatables.min.css"/>
        <!--  extension responsive  -->
        <link rel="stylesheet" type="text/css"
              href="https://cdn.datatables.net/responsive/2.2.9/css/responsive.dataTables.min.css"/>
        <link rel="stylesheet" 
              href="<c:out value='${pageContext.request.contextPath}/recursos/css/global-estilo.css'/>"
              type="text/css"  />
        <title>Clientes</title>
    </head>
    <body id="bodyCliente">
        <jsp:include page="header.jsp"/>
        <div style="height: 20px;"></div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 mb-3">
                    <div class="card">
                        <div class="card-header">
                            <h5 class="card-title">
                                <i class="bi bi-table me-2"></i> Gestión de Clientes
                            </h5> 
                        </div>
                        <div style="height: 10px;"></div>
                        <div class="col-lg-3">
                            <a id="btnNuevoCliente" class="btn btn-primary btn-sm" data-toggle="modal"  
                               data-whatever="@mdo">Nuevo Cliente</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table id="tabla_clientes" 
                                       class="table table-bordered table-striped table-hover display responsive  nowrap"
                                       width="100%">
                                    <thead class="thead-dark">
                                    <th>ID</th>
                                    <th>Cedula</th>
                                    <th>RUC</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Email</th>
                                    <th>Telefono</th>
                                    <th>Estado Cuenta</th>
                                    <th>Dirección</th>
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

        <!--  Modal para agregar o editar cliente -->
        <div class="modal fade" id="modal-cliente" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel" aria-hidden="true" >
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form:form id="formCliente" autocomplete="on">
                        <div class="modal-body">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="nombre" >Nombre:</label>
                                    <input id="nombre" type="text" class="form-control" autofocus="on" required/>
                                    <div class="valid-feedback">Ok válido!</div>
                                    <div class="invalid-feedback">Complete el campo nombre</div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="apellido" >Apellido:</label>
                                    <input id="apellido" type="text" class="form-control" required/>
                                    <div class="valid-feedback">Ok válido!</div>
                                    <div class="invalid-feedback">Complete el campo apellido</div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="cedula" >Cedula:</label>
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="bi bi-person-badge-fill"></i>
                                            </div>
                                        </div>
                                        <input id="cedula" type="text" class="form-control" required/>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Complete el campo cédula</div>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="ruc" >RUC:</label>
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="bi bi-person-badge"></i>
                                            </div>
                                        </div>
                                        <input id="ruc" type="text" class="form-control" required/>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Complete el campo RUC</div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="telefono" >Telefono:</label>
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="bi bi-telephone-fill"></i>
                                            </div>
                                        </div>
                                        <input id="telefono" type="tel" class="form-control" 
                                               placeholder="+595 9xx xxxxxx" required/>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Complete el campo telefono</div>
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="estadoCuenta" >Estado Cuenta:</label>
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="bi bi-cash-stack"></i>
                                            </div>
                                        </div>
                                        <select id="estadoCuenta" class="form-control" required>
                                            <option value="">Seleccione</option>
                                            <option value="1">agregado</option>
                                            <option value="2">modificado</option>
                                            <option value="3">eliminado</option>
                                        </select>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Complete el campo correo electronico</div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" >E-mail:</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="bi bi-envelope-fill"></i>
                                        </div>
                                    </div>
                                    <input id="email" type="email" class="form-control" placeholder="username@dominio.com" required/>
                                    <div class="valid-feedback">Ok válido!</div>
                                    <div class="invalid-feedback">Complete el campo correo electronico</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="direccion" >Dirección:</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="bi bi-geo-alt-fill"></i>
                                        </div>
                                    </div>
                                    <input id="direccion" type="text" class="form-control" required/>
                                    <div class="valid-feedback">Ok válido!</div>
                                    <div class="invalid-feedback">Complete el campo Dirección</div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <sec:csrfInput/>
                            <button id="btnCancelarCliente" type="button" class="btn btn-danger" 
                                    data-dismiss="modal"><i class="bi bi-arrow-left-circle-fill"></i> Cancelar</button>
                            <button id="btnModalCliente" type="submit" 
                                class="btn text-white"></button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div> 



        <div class="position-fixed bottom-0 right-0 p-3" 
             style="z-index: 5; right: 0; bottom: 0;">
            <div id="clienteToast" class="toast hide" role="alert" aria-live="assertive" 
                 aria-atomic="true" data-delay="5000" 
                 style="background-color: #28a745; color: white; font-weight: bold;">
                <div class="toast-header">
                    <i class="bi bi-check-circle-fill"></i>
                    <strong id="strongToastHeader" class="mr-auto"></strong>
                    <small>justo Ahora</small>
                    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" 
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="toast-body"></div>
            </div>
        </div>


        <script src="<c:out value='${pageContext.request.contextPath}/recursos/js/clientes.js'/>"
        type="text/javascript"></script>
        <!--   Datatables -->
        <script type="text/javascript" 
        src="https://cdn.datatables.net/v/dt/dt-1.11.2/datatables.min.js"></script> 
        <!-- extension responsive -->
        <script type="text/javascript" 
        src="https://cdn.datatables.net/responsive/2.2.9/js/dataTables.responsive.min.js"></script>
        <!--  Footer de la pagina -->
    </body>
</html>
