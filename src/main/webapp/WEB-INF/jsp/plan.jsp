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
        <!--  multiple-select -->
        <link rel="stylesheet" 
              href="https://unpkg.com/multiple-select@1.5.2/dist/multiple-select.min.css">
        <link rel="stylesheet" 
              href="<c:out value='${pageContext.request.contextPath}/recursos/css/global-estilo.css'/>"
              type="text/css"  />
        <title>Plan</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div style="height: 20px;"></div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 mb-3">
                    <div class="card">
                        <div class="card-header">
                            <h5 class="card-title">
                                <i class="bi bi-table me-2"></i> Lista de Plan de seguros
                            </h5> 
                        </div>
                        <div style="height: 10px;"></div>
                        <div class="col-lg-3">
                            <a id="btn-nuevo-plan" class="btn btn-primary btn-sm bi bi-plus"
                               data-toggle="modal"  data-whatever="@mdo">Agregar</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table id="tabla_planes" 
                                       class="table table-bordered table-striped table-hover display responsive  nowrap"
                                       width="100%">
                                    <thead class="thead-dark">
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Descripción</th>
                                    <th>Lista de Servicios</th>
                                    <th>Tipo de Servicio de seguro</th>
                                    <th>Operación</th>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--  Modal para agregar o editar Plan -->
        <div class="modal fade" id="modal-plan" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel" aria-hidden="true" >
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form id="form-plan"  autocomplete="on" class="needs-validation" novalidate="on" >
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="nombre" class="col-form-label">Nombre:</label>
                                <input id="nombre" type="text" class="form-control"
                                    required/>
                                <div class="valid-feedback">Ok válido!</div>
                                <div class="invalid-feedback">Complete el campo nombre</div>
                            </div>
                            <div class="form-group">
                                <label for="descripcion" class="col-form-label">
                                    Descripci&oacute;n:</label>
                                <textarea id="descripcion" name="descripcion" class="form-control"
                                    rows="2" required></textarea>
                                <div class="valid-feedback">Ok válido!</div>
                                <div class="invalid-feedback">Complete el campo descripción</div>
                            </div>
                            <div class="form-group">
                                <label for="servicio" 
                                       class="col-form-label">Lista de Servicio:</label>
                                <select id="servicio" class="form-control" 
                                        multiple ></select> 
                                <div id="servicio-feedback"></div>
                            </div>
                            <div class="form-group">
                                <label for="seguro" class="col-form-label">
                                    Lista de Seguro:</label>
                                <select id="seguro" class="form-control" required>
                                </select>
                                <div class="valid-feedback">Ok válido!</div>
                                <div class="invalid-feedback">Seleccione un Seguro</div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <sec:csrfInput/>
                            <button id="btn-modal-plan" type="submit" 
                                    class="btn text-white" ></button>
                            <button type="button" class="btn btn-secondary" 
                                    data-dismiss="modal">Cerrar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div> 

        <!--  Toast de confirmacion de exito o fracaso -->
        <div class="position-fixed bottom-0 right-0 p-3" 
             style="z-index: 5; right: 0; bottom: 0;">
            <div id="planToast" class="toast hide" role="alert" aria-live="assertive" 
                 aria-atomic="true" data-delay="7000" 
                 style="background-color: #28a745; color: white; font-weight: bold;">
                <div class="toast-header">
                    <i id="iToast" class="bi bi-check-circle-fill"></i>
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

        <script src="<c:out value='${pageContext.request.contextPath}/recursos/js/plan.js'/>"
        type="text/javascript"></script>
        <!--   Datatables -->
        <script type="text/javascript" 
        src="https://cdn.datatables.net/v/dt/dt-1.11.2/datatables.min.js"></script> 
        <!-- extension responsive -->
        <script type="text/javascript" 
        src="https://cdn.datatables.net/responsive/2.2.9/js/dataTables.responsive.min.js"></script>
        <!--  multiple-select -->
        <script src="https://unpkg.com/multiple-select@1.5.2/dist/multiple-select.min.js"></script>
        <!--  Footer de la pagina -->
    </body>
</html>
