<%@taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<!--  SweetAlert  -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
    .dropdown-item:hover, .dropdown-item:focus {
        background-color: #007bff;
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
                <sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" ></sec:authorize>
                <c:choose>
                    <c:when test="${isAdmin}">
                        <a class="nav-link text-white" href="/administracion">Administración</a>
                    </c:when>
                    <c:otherwise>
                        <a id="warningModal" href="#" class="nav-link">Administración</a>
                    </c:otherwise>
                </c:choose> 
            </li>
            <li class="nav-item dropdown">
                <sec:authorize access="hasRole('ROLE_VEND')" var="isVendedor" ></sec:authorize>
                    <a class="nav-link dropdown-toggle text-white" href="#" id="dropdown01" 
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
                            <a id="warningModal" href="#" class="dropdown-item text-white-50">Registrar Venta</a>
                        </c:otherwise>
                    </c:choose> 
                    <a class="dropdown-item text-white" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/facturacion">Facturación</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/">Servicios</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/">Auditoria</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="/">Reportes</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" href="#" id="dropdown02" 
                   data-toggle="dropdown" aria-haspopup="true" 
                   aria-expanded="false">Configuraciones</a>
                <div class="dropdown-menu bg-dark" aria-labelledby="dropdown02">
                    <a class="dropdown-item text-white" href="#">Acción</a>
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
                <a class="nav-link dropdown-toggle text-white" href="#" id="dropdownUser" 
                   data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
                    <i class="bi bi-person-fill rounded-circle"></i> <sec:authentication property="principal.username" />
                </a>
                <div class="dropdown-menu bg-dark" aria-labelledby="dropdownUser">
                    <a id="perfil" class="dropdown-item text-white" 
                       href="#">Perfil</a>
                    <a id="logout" class="dropdown-item text-white" href="#">Cerrar Sesión</a>
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
     Author     : Juan Carlos Argüello Ortiz
     */
    // Se despliega el menu de barra de navegacion movil
    'use strict';
    $('[data-toggle="offcanvas"]').on('click', function () {
        $('.offcanvas-collapse').toggleClass('open');
    });

    // Para cerrar Sesión
    $("#logout").click(function (e) {
        e.preventDefault();
        $("#logout-form").submit();
    });

    $("#warningModal").click(function () {
        swal({
            title: "Acceso Denegado",
            text: "No posee el Rol para ingresar a este modulo",
            icon: "warning",
            button: "Cerrar"
        });
    });

    $('.popover-dismiss').popover({
        trigger: 'focus'
    });


    $("#perfil").click(function (e) {
        e.preventDefault();
        let usermane = $("#perfil-form").attr("class");
        $.ajax({

        });
    });
</script>