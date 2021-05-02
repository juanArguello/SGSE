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
        <link rel="icon" href="<c:out value='recursos/images/logo.ico'/>"
            type="image/x-icon" />
        <link rel="stylesheet" href="<c:out value='recursos/css/bootstrap.min.css'/>"
            type="text/css" /> 
        <link rel="stylesheet" href="<c:out value='recursos/css/login-estilo.css'/>"
            type="text/css" /> 
        <link rel="stylesheet" 
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"  />
        <title>Login</title>
        <script type="text/javascript">
            function mostrarPassword(){
                var cambio = document.getElementById("contrasenha");
                if(cambio.type === "password"){
                    cambio.type = "text";
                }else{
                    cambio.type = "password";
                }
            } 
        </script>
    </head>
    <body>
        <div class="container col-lg-3">
            <form:form modelAttribute="usuario" action="/login" method="POST"
                class="form-horizontal" autocomplete="on"  >
                <div class="form-group text-center">
                    <img src="${pageContext.request.contextPath}/recursos/images/logo.jpg" 
                         height="80" width="80"  />
                    <p><strong class="card-title">Login</strong></p>
                </div>   
                <c:if test="${param.error != null}">
                    <div class="form-control alert-danger text-center">Usuario ó contraseña invalida</div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="form-control alert-danger text-center">Sesión Cerrada</div>
                </c:if>
                <c:if test="${param.recuperar != null}">
                    <div class="form-control alert-danger text-center">Revise su Correo</div>
                </c:if>
                <c:if test="${param.inexistente != null}">
                    <div class="form-control alert-danger text-center">El email no esta registrado</div>
                </c:if>
                <sec:authorize access="isAuthenticated()" url="https://localhost:8443/login">
                    <c:redirect url="/index" />                    
                </sec:authorize>   
                <div class="form-group">
                    <form:label path="nombreUsuario" class="h6" >Usuario:</form:label>
                    <form:input path="nombreUsuario" class="form-control"
                        placeholder="usuario" autofocus="on" required="on" />
                </div>
                <div class="form-group">
                    <form:label path="contrasenha" class="h6" >Password:</form:label>
                    <div class="input-group">
                    <form:password path="contrasenha" class="form-control" 
                            placeholder="password" required="on"  />
                       <div class="input-group-append">
                            <button id="show_password" class="btn btn-primary" 
                                    type="button" onclick="mostrarPassword()"> 
                                <i id="icono" class="fa fa-eye"></i> 
                            </button>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <label class="checkbox">
                            <input id="recordarme" name="recordarme" type="checkbox" 
                                class="custom-checkbox"/>
                            Recordarme
                        </label>
                    </div>
                </div>
                <div style="margin-top: 10px" class="form-group" align="center">
                    <div class="col-sm-12 controls">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <!-- Boton-->
                        <form:button class="btn btn-primary btn-block">Iniciar Sesión</form:button>
                    </div>
                </div>
            </form:form>
            <div class="col-sm-12 main-section">
                <div class="col-12 forgot">
                    <a href="recuperar-password">¿Has olvidado la Contraseña?</a>
                </div>
            </div>
        </div>
        <div class="footer text-center" style="margin-top: 75px ">
            Copyright &copy; 2021 &mdash; Futuro 
		</div>
        <script src="<c:out value='recursos/js/jquery-3.5.1.min.js'/>" 
            type="text/javascript"/> 
        <script src="<c:out value='recursos/js/bootstrap.min.js'/>" 
            type="text/javascript"/> 
    </body>
</html>
