$(document).ready(function () {
    'use strict';
    var idRol, usuarioNuevo;

    // para deshabilitar el envío de formularios si hay campos no válidos
    $('#nuevo-usuario').submit(function (event) {
        event.preventDefault();
        cedula = $("#cedula").val();
        ruc = $("#ruc").val();
        nombre = $("#nombre").val();
        apellido = $("#apellido").val();
        direccion = $("#direccion").val();
        telefono = $("#telefono").val();
        email = $("#email").val();
        nombreUsuario = $("#nombreUsuario").val();
        contrasenha = $("#contrasenha").val();
        usuarioNuevo = {
            "cedula": cedula,
            "ruc": ruc,
            "nombre": nombre,
            "apellido": apellido,
            "direccion": direccion,
            "telefono": telefono,
            "email": email,
            "nombreUsuario": nombreUsuario,
            "contrasenha": contrasenha,
            "registrarVentaList": [],
            "facturaList": [],
            "idEmpresa": null,
            "idRol": {},
            "contratoVentaList": []
        };

        if ($('#nuevo-usuario')[0].checkValidity() === false) {
            event.stopPropagation();
        } else {
            //enviar el submit ajax aquí
            getRol();
            $.ajax({
                url: "https://localhost:8443/apirest/usuarios",
                type: "POST",
                dataType: 'JSON',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(usuarioNuevo),
                success: function (data) {
                    location = "/administracion/usuario";
                    //$('#liveToast').toast('show'); // mostrar notificacion
                }
            });
        }
        $('#nuevo-usuario').addClass('was-validated');
    });

    $("#listaRoles").on("change", function (event) {
        idRol = $("#listaRoles option:selected").val();
    });

    function getRol() {
        $.getJSON({
            url: "https://localhost:8443/apirest/roles/"+idRol,
            success: function (data){
                Object.assign(usuarioNuevo.idRol, data);
            }
        });
    }
   

});








