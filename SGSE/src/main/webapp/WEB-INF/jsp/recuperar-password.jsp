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
        <link rel="icon" href="<c:out value='resources/images/logo.ico'/>"
            type="image/x-icon" />
        <link rel="stylesheet" href="<c:out value='resources/css/bootstrap.min.css'/>"
            type="text/css" /> 
        <link rel="stylesheet" href="<c:out value='resources/css/login-estilo.css'/>"
            type="text/css" /> 
        <title>Recuperar Contraseña</title>
    </head>
    <body>
        <div class="container col-lg-3">
            <form:form  method="POST" action="/recuperar-password" 
                class="form-horinzontal" autocomplete="on">
                <div class="form-group text-center">
                    <img src="<c:out value="resources/images/logo.jpg"/>" 
                         height="80" width="80"  />
                    <p><strong class="card-title">Recuperar Contraseña</strong></p>
                </div>
                <div class="form-group">
                    <form:label path="email" class="h5">Correo</form:label>
                    <form:input path="email" type="email" class="form-control" 
                        placeholder="usuario@dominio.com" autofocus="on" required="on" />
                    <sec:csrfInput/>
                </div>
                <div class="form-group" align="center">
                    <form:button  class="btn btn-primary">Recuperar</form:button>
                </div>
            </form:form>
        </div>
        <div class="footer text-center" style="margin-top: 230px  ">
            Copyright &copy; 2021 &mdash; Futuro 
		</div>
        <script src="<c:out value='resources/js/jquery-3.5.1.min.js'/>" 
            type="text/javascript"/> 
        <script src="<c:out value='resources/js/bootstrap.min.js'/>" 
            type="text/javascript"/> 
    </body>
</html>
