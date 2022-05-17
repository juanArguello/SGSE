$(document).ready(function () {
    var id, opcion;
    var fila; //capturar la fila para editar o borrar el registro
    var form = $(".needs-validation");
    let urlEndPoint = sessionStorage.getItem("urlEndPoint");
    var tablaPermiso = $('#tabla_permisos').DataTable({
        "ajax": {
            "url": urlEndPoint+"/permisos",
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
        $("#form-permiso").trigger("reset");
        $(".modal-header").css("background-color", "#28a745");
        $(".modal-title").css("color", "white");
        $(".modal-title").text("Nuevo Permiso");
        $("#btnModalPermiso").text("Guardar").css("background-color", "#28a745");
        $("#modal-permiso").modal("show");
    });
    
    // Al abrir el modal realiza el autofocus en el primer input
    $('#modal-permiso').on('shown.bs.modal', function () {
        $('#nombre').trigger('focus');
    });
    
    // Resetea el class del formulario al cerrar el modal
    $('#modal-permiso').on('hidden.bs.modal', function (event) {
        $("#form-permiso").attr('class', 'needs-validation');
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

    //submit para el Alta y Actualización
    $("#form-permiso").submit(function (event) {
        //evita el comportambiento normal del submit, es decir, recarga total de la página
        event.preventDefault();
        nombre = $("#nombre").val();
        descripcion = $("#descripcion").val();
        if($("#form-permiso")[0].checkValidity() === false){
            event.stopPropagation();
        }else {
            createOrUpdatePermiso(nombre,descripcion);
        }
        $('#form-permiso').addClass('was-validated');
    });
   
    function createOrUpdatePermiso(nombre,descripcion){
        if (opcion === 1) {    // Crear nuevo permiso
            $.ajax({
                url: urlEndPoint+"/permisos",
                type: "POST",
                dataType: 'JSON',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify({"nombre": nombre, "descripcion": descripcion}),
                success: function (data, textStatus, jqXHR) { // cuando es exitoso el insert permiso
                    $("#modal-permiso").modal("hide");
                    tablaPermiso.ajax.reload(null, false);
                    $("#strongToastHeader").text("Registrado");
                    $(".toast-body").text(data.mensaje);
                    $('#permisoToast').toast('show'); // mostrar notificacion
                },
                error: function (jqXHR, textStatus, errorThrown) { //Error
                    if (jqXHR.status === 500) { // cuando ocurre error interno del servidor
                        responseServer = JSON.parse(jqXHR.responseText);
                        $("#modal-permiso").modal("hide");
                        $('#permisoToast').addClass("bg-danger");
                        $("#strongToastHeader").text("Error 500");
                        $("#iToast").removeClass('bi bi-check-circle-fill').addClass('bi bi-bug-fill');
                        $(".toast-body").text(responseServer.mensaje);
                        $('#permisoToast').toast('show'); // mostrar notificacion
                    }else if(jqXHR.status === 400){ // cuando los campos son incompleto
                        let response = JSON.parse(jqXHR.responseText);
//                        $("#descripcion-invalid").text(response.errores[0]);
//                        $("#nombre-invalid").text(response.errores[1]);
                    }   
                }
            });
        } else if (opcion === 2) { // actualizar permiso
            $.ajax({
                url: urlEndPoint+"/permisos/"+id,
                type: "PUT",
                dataType: "JSON",
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify({"nombre": nombre, "descripcion": descripcion}),
                success: function (data, textStatus, jqXHR) {
                    $("#modal-permiso").modal("hide");
                    tablaPermiso.ajax.reload(null, false);
                    $("#strongToastHeader").text("Actualizado");
                    $(".toast-body").text("El Permiso ha sido actualizado con éxito");
                    $('#permisoToast').toast('show');
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    if (jqXHR.status === 400) {
                        let response = JSON.parse(jqXHR.responseText);
//                        $("#descripcion-invalid").text(response.errores[0]);
//                        $("#nombre-invalid").text(response.errores[1]);
                    }else if(jqXHR.status === 404) {
                        
                    }else if(jqXHR.status === 500) {
                        responseServer = JSON.parse(jqXHR.responseText);
                        $("#modal-permiso").modal("hide");
                        $('#permisoToast').addClass("bg-danger");
                        $("#strongToastHeader").text("Error 500");
                        $("#iToast").removeClass('bi bi-check-circle-fill').addClass('bi bi-bug-fill');
                        $(".toast-body").text(responseServer.mensaje);
                        $('#permisoToast').toast('show'); // mostrar notificacion
                    }

                }
            });
        }   
    }

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
        } else { // Cuando la tabla de datos esta en escritorio
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
                    url: urlEndPoint+"/permisos/"+id,
                    type: 'DELETE',
                    success: function (data, textStatus, jqXHR) {
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


});

