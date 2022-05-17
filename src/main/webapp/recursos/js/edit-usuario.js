$(document).ready(function () {
    
    var usuarioEditado, usuario;
    var path = location.pathname;
    pathArray = path.split("/");
    idRequest = pathArray[pathArray.length-1];
    let urlEndPoint = sessionStorage.getItem("urlEndPoint");
    let urlRoot = sessionStorage.getItem("urlRoot");

    $.getJSON(urlEndPoint+"/usuarios/"+idRequest,function(data){
        usuario = data;
        rol = usuario.idRol;
        /*if(usuarioLista.length > 0){
            $.each(usuarioLista,function(i,item) {
                arrayUsuarios.push(item);
            });
        }*/
    });
    
    // detecta el evento del cambio de un select del Rol
    $("#idRol").change(function(){
        var id;
        $("#idRol option:selected").each(function () {
            id = $(this).val(); // obtiene el id y realiza una peticion GET de Rol
            getRol(id);
        });
    }).change();
  
    // valida los inputs del formulario de acuerdo a las reglas
    $('#editar-usuario').validate({
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
            idRol: {required: true},
            estado: {required: true},
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
            idRol: {required: "Por favor seleccione un Rol"},
            estado: {required: "Por favor seleccione un Estado"},
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
            usuarioEditado = {
                cedula: parseInt($("#cedula").val()),
                ruc: $("#ruc").val(),
                nombre: $("#nombre").val(),
                apellido: $("#apellido").val(),
                direccion: $("#direccion").val(),
                telefono: $("#telefono").val(),
                email: $("#email").val(),
                fechaIngreso: usuario.fechaIngreso,
                estado: $("#estado").val(),
                nombreUsuario: $("#nombreUsuario").val(),
                contrasenha: usuario.contrasenha,
                registrarVentaList: usuario.registrarVentaList,
                facturaList: usuario.facturaList,
                idEmpresa: usuario.idEmpresa,
                idRol: rol,
                contratoVentaList: usuario.contratoVentaList
            };
            $.ajax({
                url: urlEndPoint+"/usuarios/"+idRequest,
                type: "PUT",
                dataType: "JSON",
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify(usuarioEditado),
                success: function (data, textStatus, jqXHR) { // cuando es exitoso la actualizacion de un usuario
                    location = urlRoot+"/administracion/usuario";
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(jqXHR.responseText.errores);
                }
            });
        }
    });
    
    
    function getRol(id) {
        $.getJSON(urlEndPoint+"/roles/"+id, function(data){
            rol = data;
        });
    }

});

