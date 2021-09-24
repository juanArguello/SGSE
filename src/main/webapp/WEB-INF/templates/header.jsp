<%@taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
    <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" >
            <a class="navbar-brand mr-auto mr-lg-0" href="#">
                <img src="${pageContext.request.contextPath}/recursos/images/logo.jpg" 
                    height="30" width="30"  />
            </a>
            <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link text-white" href="/">SGSE<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item"> 
                        <sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" ></sec:authorize>
                            <c:choose>
                                <c:when test="${isAdmin}">
                                    <a class="nav-link text-white" href="/administracion">Administración</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/" class="nav-link" data-toggle="modal" 
                                   data-target="#myModal">Administración</a>
                                </c:otherwise>
                        </c:choose> 
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/">Servicios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/">Ventas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/">Auditoria</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/">Reportes</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-white" href="/" id="dropdown01" 
                           data-toggle="dropdown" aria-haspopup="true" 
                           aria-expanded="false">Configuraciones</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown01">
                            <a class="dropdown-item" href="#">Acción</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                </ul>
                <ul class="navbar-nav px-3">
                    <li class="nav-item text-nowrap">
                        <a class="nav-link text-white" 
                            href="/">Usuario: <sec:authentication property="principal.username"/></a>
                    </li>
                    <li class="nav-item text-nowrap">
                        <a id="logout" class="nav-link text-white" href="#">Cerrar Sesión</a>
                        <form id="logout-form" action="<c:url value='/logout'/>" method="POST">
                            <sec:csrfInput/>
                        </form>
                    </li>
                </ul>
            </div>
        </nav>