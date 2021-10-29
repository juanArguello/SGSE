$(document).ready(function () {
    'use strict';
    let arrayPermisos = new Array();
    
    let a = '[';
    $("#nuevo-rol").submit(function (event) {
        event.preventDefault();
        nombre = $("#nombre").val();
        descripcion = $("#descripcion").val();
        listaId = $("#listaPermisos").val();
        
        rolNuevo = {nombre: nombre, descripcion: descripcion, permisosList: [], usuarioList: []};
        $.each(listaId, function (i, id) {
            $.getJSON({
                url:"https://localhost:8443/apirest/permisos/"+id,
                contentType: 'application/json; charset=UTF-8',
                success:function (data) {
                    a += JSON.stringify(data);
                }
            });
                     
            
        });
        console.log(a);
        let rolJSON = JSON.stringify(rolNuevo, (key, value) => {
            if (key === "permisosList") {
                return arrayPermisos;
            }
            return value;
        });
        

    });
});

