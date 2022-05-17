<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <link rel="stylesheet" type="text/css" 
              href="<c:out value='${pageContext.request.contextPath}/recursos/css/global-estilo.css'/>" />
        <title>Perfil</title>
    <body>
        <jsp:include page="header.jsp"/>
        <div style="height: 20px;"></div>
        <div class="container">
            <div class="card">
                <div class="card-header bg-primary text-white" style="">
                    <h4 class="card-title">
                        <i class="bi bi-person-square"></i> Mi Cuenta
                    </h4>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-12">
                            <form:form modelAttribute="perfil-usuario">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <form:label path="nombre" class="h5">Nombre</form:label>
                                        <form:input path="nombre" class="form-control" value="" readonly="on"/>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <form:label path="apellido" class="h5">Apellido</form:label>
                                        <form:input path="apellido" class="form-control" value="" readonly=""/>
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
                                            <form:input path="cedula" class="form-control" value="" 
                                                readonly=""/>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <form:label path="ruc" class="h5">RUC</form:label>
                                        <form:input path="ruc" class="form-control" value=""  
                                            readonly="" />
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
                                            <form:input path="nombreUsuario" class="form-control" value="" 
                                                readonly="on"/>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <form:label path="idRol" class="h5">Asociar Rol</form:label>
                                        <form:input path="idRol.nombre" class="form-control" 
                                            value="" readonly=""/>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <form:label path="estado" class="h5">Estado</form:label>
                                        <form:input path="estado"  class="form-control"  readonly=""/>
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
                                                <form:input path="email" type="email" class="form-control" 
                                                    value=""/>
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
                                            <form:input path="telefono" class="form-control" 
                                                value="" readonly="on"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <form:label path="direccion" class="h5">Direccion</form:label>
                                    <form:textarea path="direccion" class="form-control" rows="2" value=""></form:textarea>
                                </div>
                                <div style="margin-top: 20px" class="form-group" align="center">
                                    <div class="col-sm-4 justify-content-center">
                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="height: 50px;"></div>
        <script type="text/javascript">
            /*$.ajax({
                url: "https://localhost:8443/apirest/usuarios/"+1,
                type: "GET",
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                    $("#nombre").val(data.nombre);
                    $("#apellido").val(data.apellido);
                    $("#cedula").val(data.cedula);
                    $("#ruc").val(data.ruc);
                    $("#nombreUsuario").val(data.nombreUsuario);
                    $("#rol").val(data.idRol.nombre).text(data.idRol.nombre);
                    $("#estado").val(data.estado).text(data.estado);
                    $("#email").val(data.email);
                    $("#telefono").val(data.telefono);
                    $("#direccion").val(data.direccion);
                }
            });*/
            
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
    </body>
</html>
