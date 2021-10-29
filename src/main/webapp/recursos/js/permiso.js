$(document).ready(function () {
    var id, opcion;
    var fila; //capturar la fila para editar o borrar el registro
    tablaPermiso = $('#tabla_permisos').DataTable({
        "ajax": {
            "url": "https://localhost:8443/apirest/permisos",
            "method": 'GET',
            "dataSrc": ""
        },
        "columns": [
            {"data": "id"},
            {"data": "nombre"},
            {"data": "descripcion"},
            {"defaultContent": "<div class='text-center'><div class='btn-group'><button class='btn btn-warning btn-sm text-white btnEditar' data-toggle='tooltip' data-placement='top' title='Editar Permiso'><i class='bi bi-pencil-fill'></i></button><button class='btn btn-danger btn-sm btnBorrar' data-toggle='tooltip' data-placement='top' title='Eliminar Permiso'><i class='bit bi-trash-fill'></i></button></div></div>"}
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
                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "sProcessing": "Procesando..."
        }
    });

    //botón agregar nuevo permiso 
    $("#btnNuevoPermiso").click(function () {
        opcion = 1; //alta           
        id = null;
        $("#formPermiso").trigger("reset");
        $(".modal-header").css("background-color", "#28a745");
        $(".modal-title").css("color", "white");
        $(".modal-title").text("Nuevo Permiso");
        $("#btnModalPermiso").text("Guardar").css("background-color", "#28a745");
        $("#modal-permiso").modal("show");
    });


    //botón EDITAR permiso  
    $("#tabla_permisos tbody").on("click", ".btnEditar", function () {
        fila = $(this).closest("tr");
        datos = $('#tabla_permisos').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if (datos === undefined) {
            var selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_permisos').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            $("#nombre").val(rowData.nombre);
            $("#descripcion").val(rowData.descripcion);
        } else {
            id = parseInt(datos.id); //capturo el ID
            $("#nombre").val(datos.nombre);
            $("#descripcion").val(datos.descripcion);
        }
        opcion = 2; //editar

        $(".modal-header").css("background-color", "orange");
        $(".modal-title").css("color", "white");
        $(".modal-title").text("Editar Permiso");
        $("#btnModalPermiso").text("Editar").css("background-color", "orange");
        $("#modal-permiso").modal("show");
    });



    //Borrar permiso
    $("#tabla_permisos tbody").on("click", ".btnBorrar", function () {
        var selected_row, nombrePermiso;
        fila = $(this).closest("tr");
        datos = $('#tabla_permisos').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if (datos === undefined) {
            selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_permisos').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            nombrePermiso = rowData.nombre;
        } else {
            id = parseInt(datos.id); //capturo el ID
            nombrePermiso = datos.nombre;
        }
        swal({
            title: "Estas seguro de Eliminar el permiso \"" + nombrePermiso + "\"",
            text: "Una vez eliminado no se prodra restablecer",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then((OK) => {
            if (OK) {
                $.ajax({
                    url: "https://localhost:8443/apirest/permisos/" + id,
                    type: 'DELETE',
                    success: function () {
                        // Cuando la tabla de datos es responsive
                        if (datos === undefined) {
                            tablaPermiso.row(selected_row).remove().draw();
                        } else {
                            tablaPermiso.row(fila).remove().draw();
                        }
                        swal("Registro eliminado!", {icon: "success"});
                    },
                    error: function () {
                        swal("Error...", "No se pudo Eliminar el registro!", "error");
                    }
                });
            }
        });
    });


    //submit para el Alta y Actualización
    $("#formPermiso").submit(function (event) {
        //evita el comportambiento normal del submit, es decir, recarga total de la página
        event.preventDefault();
        nombre = $("#nombre").val();
        descripcion = $("#descripcion").val();

        if (opcion === 1) {    // Crear nuevo permiso
            $("#strongToastHeader").text("Registrado");
            $(".toast-body").text("Se ha registrado el permiso exitosamente");
            $.ajax({
                url: "https://localhost:8443/apirest/permisos",
                type: "POST",
                dataType: 'JSON',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify({"nombre": nombre, "descripcion": descripcion}),
                success: function (data) {
                    tablaPermiso.ajax.reload(null, false);
                    $('#liveToast').toast('show'); // mostrar notificacion
                }
            });
        } else if (opcion === 2) { // actualizar permiso
            $("#strongToastHeader").text("Actualizado");
            $(".toast-body").text("Se ha actualizado el permiso exitosamente");
            $.ajax({
                url: "https://localhost:8443/apirest/permisos/" + id,
                type: "PUT",
                dataType: "JSON",
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify({"nombre": nombre, "descripcion": descripcion}),
                success: function (data) {
                    tablaPermiso.ajax.reload(null, false);
                    $('#liveToast').toast('show');
                }
            });
        }

        $("#modal-permiso").modal("hide");
    });



});

