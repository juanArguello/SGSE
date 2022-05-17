$(document).ready(function () {

    let usuarioNuevo, rol;
    let urlEndPoint = sessionStorage.getItem("urlEndPoint");
    let urlRoot = sessionStorage.getItem("urlRoot");

    // detecta el evento del cambio de un select del Rol
    $("select").change(function(){
        var id;
        $("select option:selected").each(function () {
            id = $(this).val(); // obtiene el id y realiza una peticion GET de Rol
            getRol(id);
        });
    }).change();
    
    // valida los inputs del formulario de acuerdo a las reglas
    $('#nuevo-usuario').validate({
        rules: {
            nombre: {required: true},
            apellido: {required: true},
            cedula: {required: true},
            email: {
                required: true,
                email: true
            },
            nombreUsuario: {
                required: true,
                minlength: 4
            },
            contrasenha: {
                required: true,
                minlength: 8
            },
            idRol: {required: true},
            telefono: {required: true},
            direccion: {required: true}
        },
        messages: {
            nombre: {required: "El campo Nombre no puede estar vacio"},
            apellido: {required: "El campo Apellido no puede estar vacio"},
            cedula: {required: "El campo Cedula no puede estar vacio"},
            email: {
                required: "Complete el campo Correo Electronico",
                email: "Ingrese un Correo Electronico válido"
            },
            nombreUsuario: {
                required: "Complete el campo Nombre de Usuario",
                minlength: "El campo Nombre Usuario como minimo debe tener 4 caracteres"
            },
            contrasenha: {
                required: "El campo Contraseña no puede estar vacio",
                minlength: "La Contraseña debe tener como minimo 8 caracteres"
            },
            idRol: {required: "Por favor seleccione un Rol"},
            telefono: {required: "El campo Telefono no puede estar vacio"},
            direccion: {required: "El campo Dirección no puede estar vacio"}
        },
        errorElement: 'span',
        errorPlacement: function (error, element) {
            error.addClass('invalid-feedback');
            element.closest('.form-group').append(error);
        },
        highlight: function (element, errorClass, validClass) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).removeClass('is-invalid').addClass('is-valid');
        },
        submitHandler: function (form) {
            console.log(form);
            usuarioNuevo = {
                cedula: parseInt($("#cedula").val()),
                ruc: $("#ruc").val(),
                nombre: $("#nombre").val(),
                apellido: $("#apellido").val(),
                direccion: $("#direccion").val(),
                telefono: $("#telefono").val(),
                email: $("#email").val(),
                fechaIngreso: new Date(),
                nombreUsuario: $("#nombreUsuario").val(),
                contrasenha: $("#contrasenha").val(),
                registrarVentaList: [],
                facturaList: [],
                idEmpresa: null,
                idRol: rol,
                contratoVentaList: []
            };
            $.ajax({
                url: urlEndPoint + "/usuarios",
                type: "POST",
                dataType: "JSON",
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(usuarioNuevo),
                success: function (data, textStatus, jqXHR) { // cuando es exitoso el insert de un usuario
                    location = urlRoot + "/administracion/usuario";
                },
                error: function (jqXHR, textStatus, errorThrown) {

                }
            });
        }
    });
    
    
    function getRol(id) {
        $.getJSON(urlEndPoint+"/roles/" + id, function (data) {
            rol = data;
        });
    }


});








