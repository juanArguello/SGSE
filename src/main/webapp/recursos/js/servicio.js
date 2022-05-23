$(document).ready(function () {
    var id, opcion = 1;
    var fila; //capturar la fila para editar o borrar el registro
    let urlEndPoint = sessionStorage.getItem("urlEndPoint");
    let datosForm;
    var tablaServicios = $("#tabla_servicios").DataTable({
        "ajax": {
            "url": urlEndPoint + "/servicios",
            "method": 'GET',
            "dataSrc": ""
        },
        "columns": [
            {"data": "id"},
            {"data": "nombre"},
            {"data": "descripcion"},
            {"data": "planList", render: function (data, type, row, meta) {
                    if (data.length > 0) {
                        return '<div class="text-center"><button class="btn btn-info btn-sm text-center btn-plan" data-toggle="tooltip" data-placement="top" title="Ver Planes">' + data.length + ' Planes</button></div>';
                    } else if (data.length === 0) {
                        return '<div class="text-center"><span class="btn btn-danger btn-sm" >Plan asociado: ' + data.length + '</span></div>';
                    }
                }
            },
            {"defaultContent": "<div class='text-center'><div class='btn-group'><a class='btnEditar' data-toggle='tooltip' data-placement='top' title='Editar Servicio'><i class='bi bi-pencil-fill' style='color:orange;'></i></a><a class='btnBorrar' data-toggle='tooltip' data-placement='top' title='Eliminar Servicio'><i class='bit bi-trash-fill text-danger'></i></a></div></div>"}
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

    /* Peticion GET de todos los planes 
     $.getJSON(urlEndPoint + "/planes", function (data) {
     data.forEach(function (elemento) {
     planList.push(Object.create({text: elemento.nombre, value: elemento.id}));
     });
     buildMultipleSelect();
     });*/

    $('#servicio-toast').on('hidden.bs.toast', function () {
        resetearForm();
    });



    // Resetea los datos de la lista de planes al cerrar el modal
    $('#lista-planes-modal').on('hidden.bs.modal', function (event) {
        $("#titulo-modal-planes").empty();
        $("#body-modal-plan").empty();
    });

    $("#btn-reset").on("click", function (event) {
        event.preventDefault();
        resetearForm();
    });

    //ver los planes asociado a cada servicio
    $("#tabla_servicios tbody").on("click", ".btn-plan", function () {
        fila = $(this).closest("tr");
        // Cuando la tabla de datos esta en forma escritorio
        datosServicio = $('#tabla_servicios').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if (datosServicio === undefined) {
            var selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            let  rowData = $('#tabla_servicios').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            datosServicio = rowData;
        }
        $("#titulo-modal-planes").text("Lista de planes de " + datosServicio.nombre);
        let filasPlanes = '';
        datosServicio.planList.forEach(function (item) {
            filasPlanes += '<tr>';
            filasPlanes += '<td>' + item.id + '</td>';
            filasPlanes += '<td>' + item.nombre + '</td>';
            filasPlanes += '<td>' + item.descripcion + '</td>';
            filasPlanes += '</tr>';
        });
        $("#body-modal-plan").append(filasPlanes);
        $("#lista-planes-modal").modal("show");
    });

    // botón EDITAR servicio 
    $("#tabla_servicios tbody").on("click", ".btnEditar", function () {
        fila = $(this).closest("tr");
        datos = $('#tabla_servicios').DataTable().row(fila).data();
        /*selectplanes.multipleSelect('uncheckAll');
         selectplanes.multipleSelect('destroy');
         buildMultipleSelect();*/
        // Cuando la tabla de datos es responsive
        if (datos === undefined) {
            var selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_servicios').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            datosForm = rowData;
        } else {
            id = parseInt(datos.id); //capturo el ID
            datosForm = datos;
        }
        opcion = 2; //editar
        /*datosForm.planList.forEach(element => arrayId.push(element.id));
         selectplanes.multipleSelect('setSelects', arrayId);*/
        $("#form-header").removeClass("bg-primary").css("background-color", "orange");
        $("#form-title").text("Editar Servicios");
        $("#btn-servicio").text(" Editar cambios").removeClass("btn-primary")
                .addClass("bi bi-save2 text-white").css("background-color", "orange");
        $("#nombre").val(datosForm.nombre);
        $("#descripcion").val(datosForm.descripcion);
    });


    //submit para el Alta y Actualización
    $("#form-servicio").submit(function (event) {
        //evita el comportambiento normal del submit, es decir, recarga total de la página
        event.preventDefault();
        let nombre = $("#nombre").val();
        let descripcion = $("#descripcion").val();
        let formServicios = document.getElementById("form-servicio");
        if (formServicios.checkValidity() === false) {
            event.stopPropagation();
        } else {
            if (opcion === 1) {
                createServicio(nombre, descripcion);
            } else if (opcion === 2) {
                updateServicio(nombre, descripcion);
            }
        }
        /*if ($("#planes").multipleSelect('getSelects').length === 0) {
         $("#planes-feedback").removeClass("valid-feedback").addClass("invalid-feedback")
         .text("Seleccione al menos un Plan").show();
         } else {
         $("#planes-feedback").removeClass("invalid-feedback").addClass("valid-feedback")
         .text("Ok válido!").show();
         }*/
        $('#form-servicio').addClass('was-validated');
    });

    //Borrar servicios
    $("#tabla_servicios tbody").on("click", ".btnBorrar", function () {
        var selected_row;
        fila = $(this).closest("tr");
        datos = $('#tabla_servicios').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if (datos === undefined) {
            selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_servicios').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            nombre = rowData.nombre;
        } else {
            id = parseInt(datos.id); //capturo el ID
            nombre = datos.nombre;
        }
        swal({
            title: "Estas seguro de Eliminar el Servicio " + nombre,
            text: "Una vez eliminado no se prodra restablecer",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then((OK) => {
            if (OK) {
                $.ajax({
                    url: urlEndPoint + "/servicios/" + id,
                    type: 'DELETE',
                    success: function () {
                        // Cuando la tabla de datos es responsive
                        if (datos === undefined) {
                            tablaServicios.row(selected_row).remove().draw();
                        } else {
                            tablaServicios.row(fila).remove().draw();
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

    /*function buildMultipleSelect() {
     selectplanes = $('#planes').multipleSelect({
     placeholder: 'Seleccione Planes',
     data: planList,
     filter: true,
     selectAll: true,
     minimumCountSelected: 3,
     onClick: function (view) {
     getPlan(view.value);
     },
     onClose: function () {
     //servicioSelected = servicioSeleccionado.filter(object => object.selected === true);
     if ($("#planes").multipleSelect('getSelects').length === 0) {
     $("#planes-feedback").removeClass("valid-feedback").addClass("invalid-feedback")
     .text("Seleccione al menos un Plan").show();
     } else {
     $("#planes-feedback").removeClass("invalid-feedback").addClass("valid-feedback")
     .text("Ok válido!").show();
     }
     },
     formatSelectAll: function formatSelectAll() {
     return 'Seleccionar Todo';
     },
     formatAllSelected: function formatAllSelected() {
     return 'Todo seleccionado';
     },
     formatCountSelected: function formatCountSelected(count, total) {
     return count + ' de ' + total + ' seleccionado';
     },
     formatNoMatchesFound: function formatNoMatchesFound() {
     return 'No se encontraron coincidencias';
     }
     });
     }*/

    function createServicio(nombre, descripcion) {
        // datos del servicio en formato object javascript
        servicioObject = {nombre: nombre,
            descripcion: descripcion,
            planList: []};
        $.ajax({
            url: urlEndPoint + "/servicios",
            type: "POST",
            dataType: 'JSON',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(servicioObject),
            success: function (data, textStatus, jqXHR) { // cuando es exitoso el insert 
                tablaServicios.ajax.reload(null, false);
                $("#servicioToastHeader").text(" Registrado");
                $(".toast-body").text(data.mensaje);
                $('#servicio-toast').toast('show'); // mostrar notificacion
            },
            error: function (jqXHR, textStatus, errorThrown) { //Error
                responseServer = JSON.parse(jqXHR.responseText);
                $('#servicio-toast').addClass("bg-danger");
                $("#servicioToastHeader").text(capitalizarPrimeraLetra(textStatus) + " " + jqXHR.status);
                $("#iToast-service").removeClass('bi bi-check-circle-fill').addClass('bi bi-bug-fill');
                $(".toast-body").text(responseServer.mensaje + ". " + responseServer.detalle);
                $('#servicio-toast').toast('show'); // mostrar notificacion
            }
        });
    }

    function updateServicio(nombre, descripcion) {
        // datos del servicio en formato object javascript
        servicioObject = {nombre: nombre,
            descripcion: descripcion,
            planList: datosForm.planList};
        // actualizar servicios
        $.ajax({
            url: urlEndPoint + "/servicios/" + id,
            type: "PUT",
            dataType: "JSON",
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(servicioObject),
            success: function (data, textStatus, jqXHR) {
                tablaServicios.ajax.reload(null, false);
                $("#servicioToastHeader").text(" Actualizado");
                $(".toast-body").text("El servicio ha sido actualizado con éxito");
                $('#servicio-toast').toast('show'); // notificacion de servicio actualizado
            },
            error: function (jqXHR, textStatus, errorThrown) {
                responseServer = JSON.parse(jqXHR.responseText);
                $('#servicio-toast').addClass("bg-danger");
                $("#servicioToastHeader").text(capitalizarPrimeraLetra(textStatus) + " " + jqXHR.status);
                $("#iToast-service").removeClass('bi bi-check-circle-fill').addClass('bi bi-bug-fill');
                $(".toast-body").text(responseServer.mensaje + ". " + responseServer.detalle);
                $('#servicio-toast').toast('show'); // mostrar notificacion

            }
        });
    }

    /*function getPlan(id) {
     $.getJSON(urlEndPoint + "/planes/" + id, function (data) {
     arrayPlanes.push(data);
     });
     }*/

    function resetearForm() {
        opcion = 1;
        /*arrayId = [];
         arrayPlanes = [];*/
        datosForm = null;
        $("#form-servicio").trigger("reset");
        $("#form-servicio").removeClass("was-validated").addClass("needs-validation");
        $("#form-header").css("background-color", "#007bff");
        $("#form-title").css("color", "white");
        $("#form-title").text("Nuevo Servicio");
        /*selectplanes.multipleSelect('uncheckAll');
         selectplanes.multipleSelect('destroy');*/
        $("#btn-servicio").text("Agregar").css("background-color", "#007bff")
                .removeClass("bi bi-save2").addClass("bi bi-plus");
        /*buildMultipleSelect();
         $("#planes-feedback").empty();*/
        $('#nombre').trigger('focus');
    }


    function capitalizarPrimeraLetra(str) {
        return str.charAt(0).toUpperCase() + str.slice(1);
    }
});





