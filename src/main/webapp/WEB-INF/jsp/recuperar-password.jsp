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
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<c:out value='${pageContext.request.contextPath}/recursos/css/login-estilo.css'/>"
            type="text/css" /> 
        <title>Recuperar Contraseña</title>
    </head>
    <body>
        <div class="container col-lg-3">
            <form:form modelAttribute="usuario" method="POST" action="/recuperar-password" 
                class="form-horinzontal" autocomplete="on">
                <div class="form-group text-center">
                    <img src="<c:out value="${pageContext.request.contextPath}/recursos/images/logo.jpg"/>" 
                         height="80" width="80"  />
                    <p><strong class="card-title">Recuperar Contraseña</strong></p>
                </div>
                <div class="form-group">
                    <form:label path="email" class="h5">Correo</form:label>
                    <form:input path="email" type="email" class="form-control" 
                        placeholder="usuario@dominio.com" autofocus="on"/>
                    <form:errors path="email" cssClass="alert text-danger" />
                </div>
                <div class="form-group" align="center">
                    <sec:csrfInput/>
                    <form:button  class="btn btn-primary">Recuperar</form:button>
                </div>
            </form:form>
        </div>
        <div class="footer text-center">
            Copyright &copy; 2021 &mdash; Futuro 
		</div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>

    </body>
</html>
