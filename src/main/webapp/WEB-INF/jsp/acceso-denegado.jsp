<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Acceso Denegado</title>
        <style>
            .footer {
                width: 100%;
                position: absolute;
                bottom: 0;
                left: 0; 
                color: #000;
                text-align: center;
            }
        </style>
    </head>
    <body style="background-color: gainsboro;">
        <div style="height: 50px;" ></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card text-white bg-danger" >
                        <div class="card-header">
                            <div class="card-title text-center">
                                <h1>Acceso Denegado</h1>
                            </div>
                        </div>
                        <div class="card-body">
                            <h3>Error 403</h3>
                            <p class="card-text">No posee los permisos correspondiente para acceder al recurso</p>
                            <p class="card-text">HTTP/1.1 403 Forbidden <br>
                                Date:  <script> document.write(new Date());</script> </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer" >
            Copyright &copy; 2021 &mdash; Futuro 
		</div>
    </body>
</html>