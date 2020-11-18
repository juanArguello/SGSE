<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
            integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
            crossorigin="anonymous">
        <title>Login</title>
    </head>
    <body>
        <div class="container col-lg-3">
            <c:url var="loginUrl" value="j_spring_security_check"/>
            <form method="POST" action="${loginUrl}"
                Class="col-12"  autocomplete="on" >
                <c:if test="${param.logout != null}">
                    <p>Desconexion exitosa.</p>
                </c:if>
                <c:if test="${param.error != null}">
                    <p>Usuario y/o Contraseña invalida.</p>
                </c:if>
                <div class="form-group text-center">
					<img src="<c:out value="resources/images/logo.jpg"/>" 
						 height="80" width="80"  />
					<p><strong>Login</strong></p>
				</div>
				<div class="form-group">
					<label id="nombre_usuario" >Usuario</label>
                    <input type="text" class="form-control" placeholder="usuario"
                        id="nombre_usuario" name="nombre_usuario" />
				</div>
				<div class="form-group">
					<label id="contrasenha" >Password</label>
                    <input type="password" Class="form-control" placeholder="password"
                        id="contrasenha" name="contrasenha"/>
				</div>
                <div class="form-group row">
                    <div class="col-sm-10">
                        <div class="form-check">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox">recordarme
                            </label>
                        </div>
                    </div>
                </div>
				<div style="margin-top: 10px" class="form-group" align="center">
					<div class="col-sm-12 controls">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<!--Boton-->
						<button class="btn btn-success">Iniciar Sesión</button>
					</div>
				</div>
			</form>
            <div class="col-sm-12 main-section">
                <div class="col-12 forgot">
					<a href="recuperarPassword.html">Olvidaste tu Contraseña?</a>
                </div>
            </div>
        </div>
        <footer>
            <div class="container" >
                <div class="row">
                    <img class="card-footer " src="<c:out value='resources/images/grupo_daglio.png'/>" 
                        height="50" width="120" /> 
                </div>
            </div>
        </footer> 
    </body>
</html>
