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
        <link rel="stylesheet" href="<c:out value='resources/css/index-estilo.css'/>"
              type="text/css"  />
        <link rel="stylesheet" 
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"  />
        <title>Futuro</title>
        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
    </head>
    <body class="bg-light">
        <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
            <a class="navbar-brand mr-auto mr-lg-0" href="#">
                <img src="${pageContext.request.contextPath}/resources/images/logo.jpg" 
                         height="30" width="30"  />
            </a>
            <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">FUTURO<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Administración</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Servicios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Ventas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Auditoria</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Notificationes</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" 
                           data-toggle="dropdown" aria-haspopup="true" 
                           aria-expanded="false">Configuraciones</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown01">
                            <a class="dropdown-item" href="#">Acción</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                </ul>
<!--                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" 
                           placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" 
                            type="submit">Search</button>
                </form>-->
                <ul class="navbar-nav px-3">
                    <li class="nav-item text-nowrap">
                        <a class="nav-link" href="#">Usuario: ${nombre}</a>
                    </li>
                </ul>
                
                <ul class="navbar-nav px-3">
                    <li class="nav-item text-nowrap">
                        <a id="logout" class="nav-link" href="#">Cerrar Sesión</a>
                        <form id="logout-form" action="<c:url value='/logout'/>" method="POST">
                        <sec:csrfInput/>
                    </form>
                    </li>
                </ul>
            </div>
        </nav>


        <main role="main" class="container">
            <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded shadow-sm">
                <div class="lh-100">
                    <h6 class="mb-0 text-white lh-100">Futuro</h6>
                    <small>Desde 1977</small>
                </div>
            </div>

            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Recientes Actualizaciones</h6>
                <div class="media text-muted pt-3">
                    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" 
                         xmlns="http://www.w3.org/2000/svg" role="img" 
                         aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" 
                         focusable="false"><title>Placeholder</title><rect width="100%" 
                         height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" 
                         dy=".3em">32x32</text></svg>

                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        <strong class="d-block text-gray-dark">@username</strong>
                        Playing ping pong all night long, everything's all neon and hazy. Yeah, she's so in demand. She's sweet as pie but if you break her heart. But down to earth. It's time to face the music I'm no longer your muse. I guess that I forgot I had a choice.
                    </p>
                </div>
                <div class="media text-muted pt-3">
                    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#e83e8c"/><text x="50%" y="50%" fill="#e83e8c" dy=".3em">32x32</text></svg>

                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        <strong class="d-block text-gray-dark">@username</strong>
                        Standing on the frontline when the bombs start to fall. Heaven is jealous of our love, angels are crying from up above. Can't replace you with a million rings. Boy, when you're with me I'll give you a taste. There’s no going back. Before you met me I was alright but things were kinda heavy. Heavy is the head that wears the crown.
                    </p>
                </div>
                <div class="media text-muted pt-3">
                    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#6f42c1"/><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>

                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        <strong class="d-block text-gray-dark">@username</strong>
                        Will you do the same for me? It's time to face the music I'm no longer your muse. Heard it's beautiful, be the judge and my girls gonna take a vote. I can feel a phoenix inside of me. Heaven is jealous of our love, angels are crying from up above. Yeah, you take me to utopia.
                    </p>
                </div>
                <small class="d-block text-right mt-3">
                    <a href="#">Todas las Actualizaciones</a>
                </small>
            </div>

            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Suggestions</h6>
                <div class="media text-muted pt-3">
                    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

                    <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        <div class="d-flex justify-content-between align-items-center w-100">
                            <strong class="text-gray-dark">Full Name</strong>
                            <a href="#">Follow</a>
                        </div>
                        <span class="d-block">@username</span>
                    </div>
                </div>
                <div class="media text-muted pt-3">
                    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

                    <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        <div class="d-flex justify-content-between align-items-center w-100">
                            <strong class="text-gray-dark">Full Name</strong>
                            <a href="#">Follow</a>
                        </div>
                        <span class="d-block">@username</span>
                    </div>
                </div>
                <div class="media text-muted pt-3">
                    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"/><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

                    <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        <div class="d-flex justify-content-between align-items-center w-100">
                            <strong class="text-gray-dark">Full Name</strong>
                            <a href="#">Follow</a>
                        </div>
                        <span class="d-block">@username</span>
                    </div>
                </div>
                <small class="d-block text-right mt-3">
                    <a href="#">Todas las Sugerencias</a>
                </small>
            </div>
        </main>


        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>


        <script src="<c:out value='resources/js/global.js'/>"></script>
        <script src="<c:out value='resources/js/bootstrap.bundle.min.js'/>"></script>
        <script src="<c:out value='resources/js/jquery-3.5.1.min.js'/>" 
                type="text/javascript"/> 
        <script src="<c:out value='resources/js/bootstrap.min.js'/>" 
                type="text/javascript"/> 
    </body>
</html>