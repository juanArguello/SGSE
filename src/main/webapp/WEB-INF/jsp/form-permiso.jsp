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
<!--        <link rel="shortcut icon" href="<c:out value='${pageContext.request.contextPath}/recursos/images/logo.ico'/>"
              type="image/x-icon"/>-->
        <link rel="icon" href="<c:out value='${pageContext.request.contextPath}/recursos/images/favicon.png'/>"
              type="image/x-icon"/>
         <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<c:out value='${pageContext.request.contextPath}/recursos/css/index-estilo.css'/>"
              type="text/css"/>
        <link rel="stylesheet" 
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"  />
        <title>Administración</title>
    </head>
    <body>

        <div class="container col-lg-3">
            <form:form class="form-horizontal">
                <div class="form-group">
                    <form:label path="nombre" class="h5">Nombre</form:label>
                    <form:input path="nombre" class="form-control" autofocus="on" />
                </div>
                <div class="form-group">
                    <form:label path="descripcion" class="h5">Descripcion</form:label>
                    <form:input path="descripcion" class="form-control" autofocus="on" />
                </div>
                <div class="form-group"> 
                    <select  id="lista" list="rolList" placeholder="Seleccione el rol"/>
                    <datalist id="rolList">
                        <c:forEach items="${roles}" var="rol">
                            <option id="${rol.id}"><c:out value="${rol.nombre}"/></option>
                        </c:forEach> 
                    </datalist>
                </div>
                <div  class="form-group">
                    <div class="col-sm-12 controls">
                        <sec:csrfInput/>
                        <form:button class="btn btn-success" >Guardar</form:button>
                        </div>
                    </div>
            </form:form>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>

    </body>
</html>
