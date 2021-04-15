<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="es" >
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
        <link rel="stylesheet" href="<c:out value='resources/css/index-estilo.css'/>"
            type="text/css" />  
        <title>Futuro</title>
    </head>
    <body>
        <h1>Hello Index!</h1>
        ${nombre}
        <img src="/resources/images/logo.jpg" 
             height="80" width="80" />
       
        <script src="<c:out value='resources/js/jquery-3.5.1.min.js'/>" 
            type="text/javascript"/> 
        <script src="<c:out value='resources/js/bootstrap.min.js'/>" 
            type="text/javascript"/> 
    </body>
</html>
