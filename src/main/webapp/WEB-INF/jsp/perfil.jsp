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
              href="<c:out value='${pageContext.request.contextPath}/recursos/css/index-estilo.css'/>" />
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
                            <form:form modelAttribute="perfil-usuario" class="needs-validation" novalidate="on">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="nombre" class="h5">Nombre</label>
                                        <input id="nombre" class="form-control" value="" readonly/>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Complete el campo nombre</div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="apellido" class="h5">Apellido</label>
                                        <input id="apellido" class="form-control" value="" readonly/>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Complete el campo apellido</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="cedula" class="h5">Cedula</label>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="bi bi-person-badge-fill"></i>
                                                    </div>
                                                </div>
                                            <input id="cedula" class="form-control" value="" readonly/>
                                            <div class="valid-feedback">Ok válido!</div>
                                            <div class="invalid-feedback">Complete el campo cédula</div>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="ruc" class="h5">RUC</label>
                                        <input id="ruc" class="form-control" value=""  readonly/>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="nombreUsuario" class="h5">Nombre Usuario</label>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="bi bi-person-fill"></i>
                                                    </div>
                                                </div>
                                            <input id="nombreUsuario" class="form-control" value="" readonly/>
                                            <div class="valid-feedback">Ok válido!</div>
                                            <div class="invalid-feedback">Complete el campo nombre de usuario</div>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="contrasenha" class="h5">Contraseña</label>
                                            <div class="input-group">
                                            <form:password path="contrasenha" class="form-control"  required="on"/>
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
                                        <label for="idRol" class="h5">Asociar Rol</label>
                                        <select id="idRol" class="form-control"  readonly>
                                            <option id="rol" value=""></option>
                                        </select>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Por favor seleccione un Rol</div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="estado" class="h5">Estado</label>
                                        <select  class="form-control"  readonly>
                                            <option id="estado" value=""></option>
                                        </select>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Por favor seleccione un Rol</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="email" class="h5">Correo Electronico</label>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="bi bi-envelope-fill"></i>
                                                    </div>
                                                </div>
                                                <input id="email" type="email" class="form-control" value=""/>
                                            <div class="valid-feedback">Ok válido!</div>
                                            <div class="invalid-feedback">Complete el campo correo electronico</div>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="telefono" class="h5">Telefono</label>
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="bi bi-telephone-fill"></i>
                                                    </div>
                                                </div>
                                            <input id="telefono" type="tel" class="form-control" value=""/>
                                            <div class="valid-feedback">Ok válido!</div>
                                            <div class="invalid-feedback">Complete el campo telefono</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="direccion" class="h5">Direccion</label>
                                    <textarea id="direccion" class="form-control" rows="2" value=""></textarea>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">Complete el campo dirección</div>
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
            $.ajax({
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
            });
            
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
