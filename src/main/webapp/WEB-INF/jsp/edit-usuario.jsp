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
              href="<c:out value='${pageContext.request.contextPath}/recursos/css/index-estilo.css'/>" />
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
                            <form:form modelAttribute="editar-usuario" class="needs-validation" novalidate="on">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <form:label path="nombre" class="h5">Nombre</form:label>
                                        <form:input path="nombre" class="form-control" required="on" autofocus="on"/>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Complete el campo nombre</div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <form:label path="apellido" class="h5">Apellido</form:label>
                                        <form:input path="apellido" class="form-control" required="on"/>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Complete el campo apellido</div>
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
                                            <div class="invalid-feedback">Complete el campo cédula</div>
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
                                            <div class="invalid-feedback">Complete el campo nombre de usuario</div>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <form:label path="contrasenha" class="h5">Contraseña</form:label>
                                            <div class="input-group">
                                            <form:password path="contrasenha" class="form-control" required="on"/>
                                            <div class="input-group-append">
                                                <button id="mostrar_password" class="btn btn-secondary" 
                                                        type="button" onclick="mostrarPassword()" > 
                                                    <i id="icono" class="bi bi-eye-fill"></i> 
                                                </button>
                                            </div>
                                            <div class="valid-feedback">Ok válido!</div>
                                            <div class="invalid-feedback">Complete el campo contraseña</div>
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
                                        <div class="invalid-feedback">Por favor seleccione un Rol</div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <form:label path="estado" class="h5">Estado</form:label>
                                        <form:select path="estado" class="form-control" required="on">
                                            <form:option value="activo">activo</form:option>
                                            <form:option value="inactivo">inactivo</form:option>
                                        </form:select>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Por favor seleccione un Rol</div>
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
                                            <div class="invalid-feedback">Complete el campo correo electronico</div>
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
                                            <div class="invalid-feedback">Complete el campo telefono</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <form:label path="direccion" class="h5">Direccion</form:label>
                                    <form:textarea path="direccion" class="form-control" rows="2" required="on"></form:textarea>
                                    <div class="valid-feedback">Ok válido!</div>
                                    <div class="invalid-feedback">Complete el campo dirección</div>
                                </div>
                                <div style="margin-top: 20px" class="form-group" align="center">
                                    <div class="col-sm-4 justify-content-center">
                                        <form:button class="btn btn-warning btn-block font-weight-bold" >Editar</form:button>
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
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>


