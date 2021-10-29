$(document).ready(function () {
    var id, opcion, nombre;
    var fila; //capturar la fila para editar o borrar el registro
    tablaRol = $('#tabla_roles').DataTable({ 
        "ajax":{            
            "url": "https://localhost:8443/apirest/roles", 
            "method": 'GET', 
            "dataSrc":""
        },
        "columns":[
            {"data": "id"},
            {"data": "nombre"},
            {"data": "descripcion"},
            {"defaultContent": "<div class='text-center'><div class='btn-group'><button class='btn btn-info btn-sm btnVerPermiso' data-toggle='tooltip' data-placement='top' title='Ver Permisos'><i class='bi bi-zoom-in'></i></button><button class='btn btn-warning btn-sm text-white btnEditar' data-toggle='tooltip' data-placement='top' title='Editar Rol'><i class='bi bi-pencil-fill'></i></button><button class='btn btn-danger btn-sm btnBorrar' data-toggle='tooltip' data-placement='top' title='Eliminar Rol'><i class='bit bi-trash-fill'></i></button></div></div>"}
        ],
        responsive: true,
        "language": {
            "lengthMenu": "Mostrar _MENU_ registros",
            "zeroRecords": "No se encontraron resultados",
            "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "infoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sSearch": "Buscar:",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast":"Último",
                "sNext":"Siguiente",
                "sPrevious": "Anterior"
            },
            "sProcessing":"Procesando..."
        }
    });
    
    
    
    //botón agregar nuevo Rol 
    $("#btnNuevoRol").click(function(){
        
    });
    
    // Boton para visualizar los permisos asociados al rol
    $("#tabla_roles tbody").on("click", ".btnVerPermiso", function(){
        fila = $(this).closest("tr");
        datos = $('#tabla_roles').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if(datos === undefined) {
            var selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_roles').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            nombre = rowData.nombre;
        } else {
            id = parseInt(datos.id); //capturo el ID
            nombre = datos.nombre;
        }
        $("#tituloModal").text("Lista de permisos de "+nombre);
        $("#bodyModalPermiso").empty();
        $.ajax({
            url: "https://localhost:8443/apirest/roles/"+id,
            type: 'GET',
            success: function (datos) {
                var filasPermisos = '';
                $.each(datos.permisosList, function (i, item) {
                    filasPermisos += '<tr>';
                    filasPermisos += '<td>' + item.id + '</td>';
                    filasPermisos += '<td>' + item.nombre + '</td>';
                    filasPermisos += '<td>' + item.descripcion + '</td>';
                    filasPermisos += '</tr>';
                });
                $("#bodyModalPermiso").append(filasPermisos);
                $("#listaPermisosModal").modal("show");
            }
        });
    });
    
    //botón EDITAR Roles  
    $("#tabla_roles tbody").on("click", ".btnEditar", function(){
        fila = $(this).closest("tr");
        datos = $('#tabla_roles').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if(datos === undefined) {
            var selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_roles').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
        } else {
            id = parseInt(datos.id); //capturo el ID
        }
        opcion = 2; //editar
        location = "https://localhost:8443/administracion/roles/edit/"+id;
    });
   
    
    
    //Borrar Roles
    $("#tabla_roles tbody").on("click", ".btnBorrar", function(){
        var selected_row, nombreRol;
        fila = $(this).closest("tr");
        datos = $('#tabla_roles').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if(datos === undefined) {
            selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_roles').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            nombreRol = rowData.nombre;
        } else {
            id = parseInt(datos.id); //capturo el ID
            nombreRol = datos.nombre;
        }
        swal({
            title: "Estas seguro de Eliminar el Rol \""+nombreRol+"\"",
            text: "Una vez eliminado no se prodra restablecer",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then((OK) => {
            if (OK) {
                $.ajax({
                    url: "https://localhost:8443/apirest/roles/"+id,
                    type: 'DELETE',
                    success: function () {
                        // Cuando la tabla de datos es responsive
                        if(datos === undefined) {
                            tablaRol.row(selected_row).remove().draw();
                        }else {
                           tablaRol.row(fila).remove().draw();
                        }
                        swal("Registro eliminado!", {icon: "success"});
                    },
                    error: function () {
                        swal("Error...","No se pudo Eliminar el registro!","error");
                    }
                });
            } 
        });
     });
    
   
    //submit para el Alta y Actualización
    $("#formPermiso").submit(function(e){
        //evita el comportambiento normal del submit, es decir, recarga total de la página
        e.preventDefault();    
        nombre = $("#nombre").val();
        descripcion = $("#descripcion").val();
        if(opcion === 1){    // Crear nuevo permiso
            $("#strongToastHeader").text("Registrado");
            $(".toast-body").text("Se ha registrado el permiso exitosamente");
            $.ajax({
                url: "https://localhost:8443/apirest/permisos",
                type: "POST",
                dataType: 'JSON', 
                contentType: 'application/json; charset=UTF-8',
                data:  JSON.stringify({"nombre":nombre,"descripcion": descripcion}),
                success: function(data) {
                    tablaPermiso.ajax.reload(null, false);
                    $('#liveToast').toast('show');
                }
            });
        }else if(opcion === 2){ // actualizar permiso
            $("#strongToastHeader").text("Actualizado");
            $(".toast-body").text("Se ha actualizado el permiso exitosamente");
            $.ajax({
                url: "https://localhost:8443/apirest/permisos/"+id,
                type: "PUT",
                dataType:"JSON",
                contentType: 'application/json; charset=UTF-8',
                data:  JSON.stringify({"nombre":nombre,"descripcion": descripcion}),
                success: function(data) {
                    tablaPermiso.ajax.reload(null, false);
                    $('#liveToast').toast('show');
                }
            }); 
        }
        $("#modal-permiso").modal("hide"); 
    }); 
    

});

