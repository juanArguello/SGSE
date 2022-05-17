<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <!-- Bootstrap4 Dual ListBox -->
        <link rel="stylesheet" 
              href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap4-duallistbox/4.0.1/bootstrap-duallistbox.min.css"/>
        <link rel="stylesheet" type="text/css" 
              href="<c:out value='${pageContext.request.contextPath}/recursos/css/global-estilo.css'/>" />
        <title>Roles</title>
    </head>
    <body style="background-color: gainsboro;">
        <jsp:include page="header.jsp"/>
        <div style="height: 20px;"></div>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Nuevo Rol</h4>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12"> 
                            <form:form modelAttribute="nuevo-rol" autocomplete="on" class="needs-validation" novalidate="on" >
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <form:label path="nombre" class="h5">Nombre: </form:label>
                                        <form:input path="nombre" class="form-control" required="on" autofocus="on" />
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div id="nombre-invalid" class="invalid-feedback">El campo nombre no puede estar vacio</div>
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <form:label path="descripcion" class="h5">Descripción: </form:label>
                                    <form:textarea path="descripcion" class="form-control" rows="2" required="on"></form:textarea>
                                    <div class="valid-feedback">Ok válido!</div>
                                    <div id="descripcion-invalid" class="invalid-feedback">El campo descripción no puede estar vacio</div>
                                </div>
                                <div class="form-group">
                                    <label id="permisosList" class="h5">Asociar Permisos: </label>
                                    <select id="addListaPermisos" class="duallistbox" required
                                        size="7" multiple="multiple">
                                        <c:forEach items="${permisos}" var="permiso">
                                            <option value="${permiso.id}"><c:out value="${permiso.nombre}"/></option>
                                        </c:forEach>
                                    </select>
                                    <div class="valid-feedback">Ok válido!</div>
                                    <div class="invalid-feedback">Por favor seleccione un permiso</div>
                                </div>
                                <div class="form-check">
                                    <input id="confirm-permiso"  class="form-check-input" type="checkbox" value="" >
                                    <label for="confirm-permiso" class="form-check-label" >
                                        Confirmar los permisos Seleccionados
                                    </label>
                                </div>
                                <div class="form-row mt-3">
                                    <div class="form-group col-md-3">
                                        <a href="<c:out value='${pageContext.request.contextPath}/administracion/roles'/>" 
                                           class="btn btn-danger btn-block font-weight-bold">
                                            <i class="bi bi-arrow-left-circle-fill"></i> Volver</a>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <sec:csrfInput/>
                                        <form:button class="btn btn-success btn-block font-weight-bold" >Guardar</form:button>
                                        </div>
                                    </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="position-fixed bottom-0 right-0 p-3" 
                 style="z-index: 5; right: 0; bottom: 0;">
                <div id="add-rol-Toast" class="toast hide" role="alert" aria-live="assertive" 
                     aria-atomic="true" data-delay="7000" 
                     style="color: white; font-weight: bold;">
                    <div class="toast-header">
                        <i class="bi bi-bug-fill"></i>
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
            <div style="height: 50px;"></div>
           
            <script src="<c:out value='${pageContext.request.contextPath}/recursos/js/add-rol.js'/>"
            type="text/javascript"></script>
            <!-- Bootstrap4 Dual ListBox -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap4-duallistbox/4.0.1/jquery.bootstrap-duallistbox.min.js"></script>
    </body>
</html>
