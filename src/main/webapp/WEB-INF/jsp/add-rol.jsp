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
              href="<c:out value='${pageContext.request.contextPath}/recursos/css/index-estilo.css'/>" />
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
                            <form:form modelAttribute="nuevo-rol" class="needs-validation" novalidate="on">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <form:label path="nombre" class="h5">Nombre: <span style="color: red">*</span></form:label>
                                        <form:input path="nombre" class="form-control" required="on" autofocus="on" />
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Complete el campo nombre</div>
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <form:label path="descripcion" class="h5">Descripción: <span style="color: red">*</span></form:label>
                                    <form:textarea path="descripcion" class="form-control" rows="2" required="on"></form:textarea>
                                    <div class="valid-feedback">Ok válido!</div>
                                    <div class="invalid-feedback">Complete el campo descripción</div>
                                </div>
                                <div class="form-group">
                                    <form:label path="permisosList" class="h5">Asociar Permisos: <span style="color: red">*</span></form:label>
                                    <form:select path="permisosList" class="duallistbox" required="on"
                                        size="7" multiple="multiple">
                                        <c:forEach items="${permisos}" var="permiso">
                                            <form:option value="${permiso.id}"><c:out value="${permiso.nombre}"/></form:option>
                                        </c:forEach>
                                    </form:select>
                                    <div class="valid-feedback">Ok válido!</div>
                                    <div class="invalid-feedback">Por favor seleccione un permiso</div>
                                </div>
                                <div class="form-row">
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
            <div style="height: 50px;"></div>
            <script type="text/javascript">
                $(function () {
                    //Bootstrap Duallistbox
                    var bootstrapDualListbox = $('.duallistbox').bootstrapDualListbox({
                        filterTextClear: 'Mostrar todo',
                        filterPlaceHolder: 'Filtrar',
                        moveSelectedLabel: 'Mover seleccionado',
                        moveAllLabel: 'Mover todo',
                        removeSelectedLabel: 'Remover selección',
                        removeAllLabel: 'Remover todo',
                        infoText: 'Mostrar {0}',
                        infoTextFiltered: '<span class="badge badge-warning">Filtrado</span> {0} de {1}',
                        infoTextEmpty: 'Lista Vacia',
                        nonSelectedListLabel: 'No Seleccionado',
                        selectedListLabel: 'Seleccionado'
                    });
                });
                
            </script>
            
        <script src="<c:out value='${pageContext.request.contextPath}/recursos/js/add-rol.js'/>"
            type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
        <!-- Bootstrap4 Dual ListBox -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap4-duallistbox/4.0.1/jquery.bootstrap-duallistbox.min.js"></script>
    </body>
</html>
