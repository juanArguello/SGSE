$(document).ready(function () {
    var id, opcion;
    var fila; //capturar la fila para editar o borrar el registro
    tablaClientes = $('#tabla_clientes').DataTable({
        "ajax": {
            "url": "https://localhost:8443/apirest/clientes",
            "method": 'GET',
            "dataSrc": ""
        },
        "columns": [
            {"data": "id"},
            {"data": "cedula"},
            {"data": "ruc"},
            {"data": "nombre"},
            {"data": "apellido"},
            {"data": "email"},
            {"data": "telefono"},
            {"data": "estadoCuenta"},
            {"data": "direccion"},
            {"defaultContent": "<div class='text-center'><div class='btn-group'><button class='btn btn-warning btn-sm btnEditar' data-toggle='tooltip' data-placement='top' title='Editar Cliente'><i class='bi bi-pencil-fill'></i></button><button class='btn btn-danger btn-sm btnBorrar' data-toggle='tooltip' data-placement='top' title='Eliminar Cliente'><i class='bit bi-trash-fill'></i></button></div></div>"}
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
    $("#btnNuevoCliente").click(function () {
        opcion = 1; //alta           
        id = null;
        $("#formCliente").trigger("reset");
        $(".modal-header").css("background-color", "#007bff");
        $(".modal-title").css("color", "white");
        $(".modal-title").text("Agregar Cliente");
        $("#btnModalCliente").addClass("bi bi-save2");
        $("#btnModalCliente").text(" Guardar").css("background-color", "#007bff");
        $("#modal-cliente").modal("show");
    });
    
    //botón EDITAR cliente  
    $("#tabla_clientes tbody").on("click", ".btnEditar", function () {
        fila = $(this).closest("tr");
        datos = $('#tabla_clientes').DataTable().row(fila).data();
        let datosForm;
        // Cuando la tabla de datos es responsive
        if (datos === undefined) {
            var selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_clientes').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            datosForm = rowData;
        } else {
            id = parseInt(datos.id); //capturo el ID
            datosForm = datos;
        }
        opcion = 2; //editar
        $("#nombre").val(datosForm.nombre);
        $("#apellido").val(datosForm.apellido);
        $("#cedula").val(datosForm.cedula);
        $("#ruc").val(datosForm.ruc);
        $("#telefono").val(datosForm.telefono);
        $("#estadoCuenta").val(datosForm.estadoCuenta);
        $("#email").val(datosForm.email);
        $("#direccion").val(datosForm.direccion);
        

        $(".modal-header").css("background-color", "orange");
        $(".modal-title").css("color", "white");
        $(".modal-title").text("Editar Cliente");
        $("#btnModalCliente").addClass("bi bi-save2");
        $("#btnModalCliente").text(" Guardar cambios").css("background-color", "orange");
        $("#modal-cliente").modal("show");
    });
    
    //submit para el Alta y Actualización
    $("#formCliente").submit(function (event) {
        //evita el comportambiento normal del submit, es decir, recarga total de la página
        event.preventDefault();
        nombre = $("#nombre").val();
        apellido = $("#apellido").val();
        cedula = $("#cedula").val();
        ruc = $("#ruc").val();
        telefono = $("#telefono").val();
        estadoCuenta = $("#estadoCuenta").val();
        email = $("#email").val();
        direccion = $("#direccion").val();
        let cliente ={
            "cedula": cedula,
            "ruc": ruc,
            "nombre": nombre,
            "apellido": apellido,
            "direccion": direccion,
            "telefono": telefono,
            "email": email,
            "estadoCuenta": estadoCuenta,
            "compraList": [],
            "idSalon": null
        };
        if (opcion === 1) {    // Crear nuevo cliente
            $("#strongToastHeader").text("Registrado");
            $(".toast-body").text("Se ha registrado el cliente exitosamente");
            $.ajax({
                url: "https://localhost:8443/apirest/clientes",
                type: "POST",
                dataType: 'JSON',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(cliente),
                success: function (data) {
                    tablaClientes.ajax.reload(null, false);
                    $('#clienteToast').toast('show'); // mostrar notificacion
                }
            });
        } else if (opcion === 2) { // actualizar permiso
            $("#strongToastHeader").text("Actualizado");
            $(".toast-body").text("Se ha actualizado el cliente exitosamente");
            $.ajax({
                url: "https://localhost:8443/apirest/clientes/" + id,
                type: "PUT",
                dataType: "JSON",
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(cliente),
                success: function (data) {
                    tablaClientes.ajax.reload(null, false);
                    $('#clienteToast').toast('show');
                }
            });
        }

        $("#modal-cliente").modal("hide");
    });
    
    //Borrar cliente
    $("#tabla_clientes tbody").on("click", ".btnBorrar", function () {
        var selected_row, nombreCliente, apellidoCliente;
        fila = $(this).closest("tr");
        datos = $('#tabla_clientes').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if (datos === undefined) {
            selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_clientes').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            nombreCliente = rowData.nombre;
            apellidoCliente = rowData.apellido;
        } else {
            id = parseInt(datos.id); //capturo el ID
            nombreCliente = datos.nombre;
            apellidoCliente = datos.apellido;
        }
        swal({
            title: "Estas seguro de eliminar el Cliente: " + nombreCliente + " "+apellidoCliente,
            text: "Una vez eliminado no se prodra restablecer",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then((OK) => {
            if (OK) {
                $.ajax({
                    url: "https://localhost:8443/apirest/clientes/" + id,
                    type: 'DELETE',
                    success: function () {
                        // Cuando la tabla de datos es responsive
                        if (datos === undefined) {
                            tablaClientes.row(selected_row).remove().draw();
                        } else {
                            tablaClientes.row(fila).remove().draw();
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


