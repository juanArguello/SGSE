<%@taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .dropdown-item:hover, .dropdown-item:focus {
        background-color: #007bff;
    } 
    .navbar{
        padding: 0.4rem 1rem;
    }
</style>
<nav id="navbar-example2" class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" >
    <a class="navbar-brand mr-auto mr-lg-0" href="/">
        <img src="${pageContext.request.contextPath}/recursos/images/logo.jpg" 
             height="30" width="30"  />
    </a>
    <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"> 
                <sec:authorize access="hasRole('ROLE_ADMINISTRADOR')"  var="isAdmin">
                </sec:authorize>
                <c:choose>
                    <c:when test="${isAdmin}">
                        <a class="nav-link text-white" 
                           href="<c:url value='${pageContext.request.contextPath}/administracion'/>">Administraci�n</a>
                    </c:when>
                    <c:otherwise>
                        <a href="#" class="nav-link text-white-50">Administraci�n</a>
                    </c:otherwise>
                </c:choose> 
            </li>
            <li class="nav-item dropdown">
                <sec:authorize access="hasRole('ROLE_VENDEDOR')" var="isVendedor" ></sec:authorize>
                    <a class="nav-link dropdown-toggle text-white" href="/ventas" id="dropdown01" 
                       data-toggle="dropdown" aria-haspopup="true" 
                       aria-expanded="false">Ventas</a>
                    <div class="dropdown-menu bg-dark" aria-labelledby="dropdown01">
                        <a class="dropdown-item text-white" 
                           href="<c:url value='${pageContext.request.contextPath}/ventas/clientes'/>">Clientes</a>
                    <c:choose>
                        <c:when test="${isVendedor}">
                            <a class="dropdown-item text-white" 
                               href="<c:url value='${pageContext.request.contextPath}/ventas/registrar'/>">Registrar Venta</a>
                        </c:when>
                        <c:otherwise>
                            <a href="#" 
                                class="dropdown-item text-white-50">Registrar Venta</a>
                        </c:otherwise>
                    </c:choose> 
                    <a class="dropdown-item text-white" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <sec:authorize access="hasRole('')" var="" ></sec:authorize>
                    <a class="nav-link dropdown-toggle text-white" href="/seguros" id="dropdown02" 
                       data-toggle="dropdown" aria-haspopup="true" 
                       aria-expanded="false">Seguros</a>
                    <div class="dropdown-menu bg-dark" aria-labelledby="dropdown02">
                        <c:choose>
                            <c:when test="${isVendedor}">
                                <a class="dropdown-item text-white" 
                                   href="<c:url value='${pageContext.request.contextPath}/seguros'/>">Seguro</a>
                            </c:when>
                            <c:otherwise>
                                <a href="#" 
                                    class="dropdown-item text-white-50">Seguro</a>
                            </c:otherwise>
                        </c:choose> 
                        <a class="dropdown-item text-white" 
                           href="<c:url value='${pageContext.request.contextPath}/seguros/plan'/>">Plan</a>
                    <a class="dropdown-item text-white" 
                       href="<c:url value='${pageContext.request.contextPath}/seguros/servicio'/>">Servicios</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white"  href="#">Productos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/facturacion">Facturaci�n</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/">Auditoria</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/">Reportes</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" href="/herramientas" id="dropdown03" 
                   data-toggle="dropdown" aria-haspopup="true" 
                   aria-expanded="false">Herramientas</a>
                <div class="dropdown-menu bg-dark" aria-labelledby="dropdown03">
                    <c:choose>
                        <c:when test="${isAdmin}">
                            <a href="<c:url value='${pageContext.request.contextPath}/herramientas/email'/>"
                               class="dropdown-item text-white">Correo Electronico</a>
                        </c:when>
                        <c:otherwise>
                            <a href="#" class="dropdown-item text-white-50">Correo Electronico</a>
                        </c:otherwise>
                    </c:choose>
                    <a class="dropdown-item text-white" href="#">Another action</a>
                    <a class="dropdown-item text-white" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <ul class="navbar-nav px-3">
            <li class="nav-item col-6 col-md-auto">
                <a href="" class="nav-link p-2 text-white"  
                   type="button"  >
                    <i class="bi bi-bell-fill" data-toggle="tooltip" data-placement="bottom" 
                       title="Notificaciones"></i>
                </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" href="/user" id="dropdownUser" name="username" 
                   data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
                    <i class="bi bi-person-fill rounded-circle"></i> <sec:authentication property="principal.username" />
                </a>
                <div class="dropdown-menu bg-dark" aria-labelledby="dropdownUser">
                    <a id="perfil" class="dropdown-item text-white" 
                       href="<c:url value='${pageContext.request.contextPath}/user/perfil'/>">Perfil</a>
                    <a id="logout" class="dropdown-item text-white" href="#">Cerrar Sesi�n</a>
                    <form id="logout-form" action="<c:url value='/logout'/>" method="POST">
                        <sec:csrfInput/>
                    </form>
                </div>
            </li>
        </ul>
    </div>   
</nav> 

<script type="text/javascript">
    /* 
     Created on : 20-abr-2021
     Author     : Juan Carlos Arg�ello Ortiz
     */
    if(sessionStorage.getItem("urlRoot")===null && sessionStorage.getItem("urlEndPoint")===null){
        sessionStorage.setItem("urlRoot","https://localhost:8443");
        sessionStorage.setItem("urlEndPoint","https://localhost:8443/apirest");
    }
    
    window.onload = function () {
        pathActual = location.pathname.split("/")[1];
        linkHeader = $(".nav-link").toArray();
        i=0;
        linkHeader.forEach(function(item) {
            if(pathActual === item.href.split("/")[3]){
                linkHeader.at(i).classList.add("font-weight-bold");
            }
            i++;
        });
        
        // Se despliega el menu de barra de navegacion movil
        'use strict';
        $('[data-toggle="offcanvas"]').on('click', function () {
            $('.offcanvas-collapse').toggleClass('open');
        });

        // Para cerrar Sesi�n
        $("#logout").click(function (e) {
            e.preventDefault();
            sessionStorage.clear();
            $("#logout-form").submit();
        });

        
        $(".text-white-50").click(function() {
            swal({
                title: "Acceso Denegado",
                text: "No posee el Rol para ingresar a este modulo",
                icon: "warning",
                button: "Cerrar"
            });
        });

    };
    
    onbeforeunload = function() {
        $(".nav-link").toArray().forEach(function(item) {
            if(item.classList.contains("font-weight-bold")){
                item.classList.remove("font-weight-bold");
            }
        });
    };
    
    
</script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<!--  SweetAlert  -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>