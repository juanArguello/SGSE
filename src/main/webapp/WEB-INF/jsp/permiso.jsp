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
<!--        <link rel="shortcut icon" href="<c:out value='/WEB-INF/recursos/images/logo.ico'/>"
              type="image/x-icon"/>-->
        <link rel="icon" 
              href="<c:out value='/recursos/images/favicon.png'/>"
              type="image/x-icon"/>
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" type="text/css"
              href="https://cdn.datatables.net/v/dt/dt-1.11.2/datatables.min.css"/>
        <link rel="stylesheet" 
              href="<c:out value='recursos/css/index-estilo.css'/>"
              type="text/css"  />
        <link rel="stylesheet" 
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"  />
        <title>Permisos</title>
    </head>
    <body id="bodyPermiso">
        <jsp:include page="/WEB-INF/templates/header.jsp"/>
        <div style="height: 40px"></div>
        <div class="container-fluid">
            <a id="btnNuevoPermiso" class="btn btn-success btn-sm bi bi-plus"
               data-toggle="modal"  data-whatever="@mdo">Agregar</a><br><br>
            <div class="row">
                <div class="col-lg-12 mb-3">
                    <div class="card">
                        <div class="card-header">
                            <span>
                                <i class="bi bi-table me-2"></i>
                            </span> Lista de Permisos
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table id="tabla_permisos" 
                                       class="table table-bordered table-striped table-hover"
                                       style="width:100%">
                                    <thead class="thead-dark">
                                        <th>ID</th>
                                        <th>Nombre</th>
                                        <th>Descripción</th>
                                        <th>Acciones</th>
                                    </thead>
                                    <tbody>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--  Modal para agregar o editar permiso -->
        <div class="modal fade" id="modal-permiso" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel" aria-hidden="true" >
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form:form id="formPermiso" class="form-horizontal" autocomplete="on" >
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="nombre-label" class="col-form-label">Nombre:</label>
                                <input id="nombre"  class="form-control" />
                            </div>
                            <div class="form-group">
                                <label for="descripcion-label" class="col-form-label">
                                    Descripci&oacute;n:</label>
                                <textarea id="descripcion" class="form-control" rows="2" ></textarea>
                            </div>
<!--                            <div class="form-group"> 
                                <label for="rolList" class="col-form-label">Asociar Rol: </label><br>
                                <c:forEach items="${roles}" var="rol">
                                    <div class="form-check form-check-inline">
                                        <input type="checkbox" class="form-check-input" 
                                            name="rolCheckbox" value="${rol.id}" />
                                        <label class="form-check-label" for="${rol.nombre}">
                                            <c:out value="${rol.nombre}"/>
                                        </label>
                                    </div>
                                </c:forEach> 
                            </div>-->
                        </div>
                        <div class="modal-footer">
                            <sec:csrfInput/>
                            <button id="btnModalPermiso" type="submit" 
                                    class="btn text-white" ></button>
                            <button type="button" class="btn btn-secondary" 
                                    data-dismiss="modal">Cerrar</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div> 
        
       
        <script src="<c:out value='recursos/js/permiso.js'/>"
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
