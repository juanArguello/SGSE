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
        <link rel="stylesheet" type="text/css" 
              href="<c:out value='${pageContext.request.contextPath}/recursos/css/global-estilo.css'/>" />
        <title>Usuarios</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div style="height: 20px;"></div>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title">Editar Usuario</h4>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form:form modelAttribute="editar-usuario" autocomplete="on" >
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <form:label path="nombre" class="h5">Nombre</form:label>
                                        <form:input path="nombre" class="form-control" required="on" autofocus="on"/>
                                        <div class="valid-feedback">Ok válido!</div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <form:label path="apellido" class="h5">Apellido</form:label>
                                        <form:input path="apellido" class="form-control" required="on"/>
                                        <div class="valid-feedback">Ok válido!</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <form:label path="cedula" class="h5">Cedula</form:label>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="bi bi-person-badge-fill"></i>
                                                    </div>
                                                </div>
                                            <form:input path="cedula" class="form-control" required="on"/>
                                            <div class="valid-feedback">Ok válido!</div>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <form:label path="ruc" class="h5">RUC</form:label>
                                        <form:input path="ruc" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <form:label path="nombreUsuario" class="h5">Nombre Usuario</form:label>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="bi bi-person-fill"></i>
                                                    </div>
                                                </div>
                                            <form:input path="nombreUsuario" class="form-control" required="on"/>
                                            <div class="valid-feedback">Ok válido!</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label class="h5">Asociar Rol</label>
                                        <form:select path="idRol" class="form-control"  
                                            required="on">
                                            <option disabled>Seleccione el rol</option>
                                            <c:set var="idSelect" value="${rolSeleccionado}"/>
                                            <c:forEach items="${roles}" var="rol">
                                                <c:choose>
                                                    <c:when test="${rol.id == idSelect}">
                                                        <form:option value="${rol.id}" selected="selected"><c:out value="${rol.nombre}"/></form:option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <form:option value="${rol.id}"><c:out value="${rol.nombre}"/></form:option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach> 
                                        </form:select>
                                        <div class="valid-feedback">Ok válido!</div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <form:label path="estado" class="h5">Estado</form:label>
                                        <form:select path="estado" class="form-control" required="on">
                                            <form:option value="activo">activo</form:option>
                                            <form:option value="inactivo">inactivo</form:option>
                                        </form:select>
                                        <div class="valid-feedback">Ok válido!</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <form:label path="email" class="h5">Correo Electronico</form:label>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="bi bi-envelope-fill"></i>
                                                    </div>
                                                </div>
                                            <form:input path="email" type="email" class="form-control" required="on"/>
                                            <div class="valid-feedback">Ok válido!</div>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <form:label path="telefono" class="h5">Telefono</form:label>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="bi bi-telephone-fill"></i>
                                                    </div>
                                                </div>
                                            <form:input path="telefono" type="tel" class="form-control" 
                                                        placeholder="+595 9xx xxxxxx" required="on"/>
                                            <div class="valid-feedback">Ok válido!</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <form:label path="direccion" class="h5">Direccion</form:label>
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="bi bi-geo-alt-fill"></i>
                                            </div>
                                        </div>
                                        <form:input path="direccion" class="form-control" required="on"/>
                                        <div class="valid-feedback">Ok válido!</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <a href="<c:out value='${pageContext.request.contextPath}/administracion/usuario'/>" 
                                           class="btn btn-danger btn-block font-weight-bold">
                                            <i class="bi bi-arrow-left-circle-fill"></i> Volver</a>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <sec:csrfInput/>
                                        <form:button class="btn btn-block font-weight-bold text-white"
                                            style="background-color: orange;" >Editar</form:button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <div style="height: 20px;"></div>
            <script type="text/javascript">
                // visualizar u ocultar la contraseña ingresada
                function mostrarPassword() {
                    var cambio = document.getElementById("contrasenha");
                    var ojo = document.getElementById("icono");
                    if (cambio.type === "password") {
                        cambio.type = "text";
                        ojo.setAttribute("class", "bi bi-eye-slash-fill");
                    } else {
                        cambio.type = "password";
                        ojo.setAttribute("class", "bi bi-eye-fill");
                    }
                }
            </script>
        <script src="<c:out value='${pageContext.request.contextPath}/recursos/js/edit-usuario.js'/>"
            type="text/javascript"></script>
        <!-- jQuery Validation -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>
    </body>
</html>


