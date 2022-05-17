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
        <!-- Summernote css -->
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" >
        <link rel="stylesheet" type="text/css" 
              href="<c:out value='${pageContext.request.contextPath}/recursos/css/global-estilo.css'/>" />
        <title>Email</title>
        <style>
            .card-header{
                padding: 0.30rem 1.25rem;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="container mt-3 mb-4 col-md-9">
            <div class="card">
                <div class="card-header">
                    <div id="cabecera" class="card-title" style="text-align: center;">Redactar Email</div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form:form method="POST" id="emailForm" autocomplete="on" 
                                enctype="multipart/form-data" class="needs-validation" novalidate="on" >
                                <div class="form-group">
                                    <!-- <label class="col-form-label">Correo</label>-->
                                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                        <input id="correo" name="correo" type="email" class="form-control" 
                                            multiple="on"   placeholder="Correo electronico" required="on"/>
                                        <div class="input-group-append">
                                            <button class="btn btn-sm btn-secondary dropdown-toggle" 
                                                    type="button" data-toggle="dropdown" 
                                                    aria-expanded="false"><i class="bi bi-search"></i> Direccion</button>
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
                                    <!--    <label for="asunto">Asunto</label>-->
                                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                        <input type="text" class="form-control" name="asunto" 
                                               placeholder="Asunto"  required="on"/>
                                        <div class="valid-feedback">Ok válido!</div>
                                        <div class="invalid-feedback">El campo Asunto no puede estar vacio</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <!--                                <label>Mensaje</label>-->
                                    <textarea id="summernote" class="form-control" rows="3" 
                                        name="cuerpoMensaje" required="on"></textarea>
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
                                    </div>
                                </div>
                                <div style="margin-bottom: 10px">
                                    <a href="<c:out value='${pageContext.request.contextPath}/index'/>" 
                                       class="btn btn-danger">
                                        <i class="bi bi-arrow-left"></i> Cancelar
                                    </a>
                                    <sec:csrfInput/>
                                    <button id="btnSubmitEmail" type="submit" class="btn btn-info">
                                        <i class="bi bi-envelope-fill"></i> Enviar
                                    </button>
                                </div>
                            </form:form>
                        </div>
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

        <script src="<c:out value='${pageContext.request.contextPath}/recursos/js/email.js'/>"
        type="text/javascript"></script>
        <!-- Summernote js -->
        <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-es-ES.min.js"></script>
    </body>
</html>
