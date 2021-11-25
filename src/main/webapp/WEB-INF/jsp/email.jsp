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
        <title>Email</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="container mt-3 mb-4 col-md-8">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title" style="text-align: center;">Redactar Email</h5>
                </div>
                <div class="card-body">
                    <div class="container">
                        <form:form method="POST" id="emailForm" autocomplete="on" enctype="multipart/form-data"
                                   class="needs-validation" novalidate="on" >
                            <c:if test="${param.enviado != null}">
                                <div class="form-control alert-success text-center">Email enviado</div>
                            </c:if>
                            <div class="form-group">
                                <label>Correo</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <input id="correo" name="correo" type="email" class="form-control" 
                                           placeholder="Correo electronico" required="on"/>
                                    <div class="input-group-append">
                                        <button class="btn btn-sm btn-outline-secondary dropdown-toggle" 
                                                type="button" data-toggle="dropdown" 
                                                aria-expanded="false"><i class="bi bi-search"></i> Direcciones</button>
                                        <div class="dropdown-menu">
                                            <a id="email_cliente" class="dropdown-item">Buscar Clientes</a>
                                            <a id="email_user" class="dropdown-item">Buscar Usuarios</a>
                                        </div>
                                    </div>
                                    <div class="valid-feedback">Ok válido!</div>
                                    <div class="invalid-feedback">El campo Correo no puede estar vacio</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="asunto">Asunto</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <input type="text" class="form-control" name="asunto" 
                                           placeholder="Asunto"  required="on"/>
                                    <div class="valid-feedback">Ok válido!</div>
                                    <div class="invalid-feedback">El campo Asunto no puede estar vacio</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Mensaje</label>
                                <textarea class="form-control" rows="4" name="cuerpoMensaje"
                                          required="on"></textarea>
                                <div class="valid-feedback">Ok válido!</div>
                                <div class="invalid-feedback">El campo Mensaje no puede estar vacio</div>
                            </div>
                            <div class="form-group">
                                <label>Archivo Adjunto (Opcional)</label>
                                <div class="custom-file">
                                    <label for="customFile" class="custom-file-label">
                                        <i class="bi bi-paperclip"></i> Seleccionar Archivo, Max. 32MB</label>
                                    <input type="file" class="custom-file-input" id="archivoAdjunto" 
                                           name="archivoAdjunto" multiple="multiple"/>
                                    <div class="valid-feedback">Ok válido!</div>
                                </div>
                            </div>
                            <div style="margin-bottom: 10px">
                                <a href="<c:out value='${pageContext.request.contextPath}/index'/>" class="btn btn-danger">
                                    <i class="bi bi-arrow-left"></i> Cancelar
                                </a>
                                <sec:csrfInput/>
                                <button type="submit" class="btn btn-info">
                                    <i class="bi bi-envelope-fill"></i> Enviar
                                </button>
                            </div>
                        </form:form>
                    </div>

                </div>
            </div>
        </div>


        <!--  modal de lista de permisos asociado a un rol  -->
        <div class="modal fade" id="listaEmailModal" tabindex="-1" 
             aria-labelledby="exampleModalLongTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header bg-dark">
                        <h5 id="tituloModalEmail" class="modal-title text-white" 
                            style="text-align: center;"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <table id="tabla_lista_Email" 
                               class="table table-bordered table-striped table-hover table-responsive"
                               width="100%">
                            <thead>
                            <th>Cedula</th>
                            <th>Nombre y Apellido</th>
                            <th>Email</th>
                            </thead>
                            <tbody id="bodyModalEmail"></tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <script>
            $("#email_cliente").on("click", function (event) {
                $("#bodyModalEmail").empty();
                $("#tituloModalEmail").text("Lista de Direcciones de Clientes");
                $.getJSON("https://localhost:8443/apirest/clientes", function (data) {
                    var filasEmailCliente = '';
                    $.each(data, function (i, item) {
                        filasEmailCliente += '<tr>';
                        filasEmailCliente += '<td>' + item.cedula + '</td>';
                        filasEmailCliente += '<td>' + item.nombre + ' ' + item.apellido + '</td>';
                        filasEmailCliente += '<td>' + item.email + '</td>';
                        filasEmailCliente += '</tr>';
                    });
                    $("#bodyModalEmail").append(filasEmailCliente);
                    $("#listaEmailModal").modal("show");
                });

            });
            $("#email_user").on("click", function (event) {
                $("#bodyModalEmail").empty();
                $("#tituloModalEmail").text("Lista de Direcciones de Usuarios");
                $.getJSON("https://localhost:8443/apirest/usuarios", function (data) {
                    var filasEmailUser = '';
                    $.each(data, function (i, item) {
                        filasEmailUser += '<tr>';
                        filasEmailUser += '<td>' + item.cedula + '</td>';
                        filasEmailUser += '<td>' + item.nombre + ' ' + item.apellido + '</td>';
                        filasEmailUser += '<td>' + item.email + '</td>';
                        filasEmailUser += '</tr>';
                    });
                    $("#bodyModalEmail").append(filasEmailUser);
                    $("#listaEmailModal").modal("show");
                });

            });

            $(function () {
                $('#listaEmailModal').on('shown.bs.modal', function () {
                    $("#bodyModalEmail tr").click(function (e) {
                        var email = $(this).find("td:eq(2)").text();
                        $("#correo").val(email);
                        $("#listaEmailModal").modal("hide");
                    });
                });

                $("input:file").change(function () {
                    var fileName = $(this).val();
                    $(".custom-file-label").html("Archivo: " + fileName);
                });


            });

            $("#emailForm").submit(function (event) {
                event.preventDefault();
                if ($("#emailForm")[0].checkValidity() === false) {
                    event.stopPropagation();
                } else {
                    $(this).submit();
                }
                $('#emailForm').addClass('was-validated');

            });

        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
    </body>
</html>
