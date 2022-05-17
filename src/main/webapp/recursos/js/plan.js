$(document).ready(function () {
    let urlEndPoint = sessionStorage.getItem("urlEndPoint");
    var id, opcion;
    var arrayServicios = new Array(); // array de servicios 
    var arrayId = new Array(); // array de Id 
    var seguro = null; // Object seguro
    var servicioList = new Array();
    var servicioSeleccionado = new Array();
    var servicioArray = new Array();
    var selectServicios = null;
    var tablaPlan = $("#tabla_planes").DataTable({
        "ajax": {
            "url": urlEndPoint + "/planes",
            "method": 'GET',
            "dataSrc": ""
        },
        "columns": [
            {"data": "id"},
            {"data": "nombre"},
            {"data": "descripcion"},
            {"data": "serviciosList",
                render: function (data, type, row, meta) {
                    dropdown = '<div class="text-center"><div class="dropdown">';
                    dropdown += '<button class="btn btn-info btn-block dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-expanded="false">';
                    dropdown += 'Servicios</button><div class="dropdown-menu" aria-labelledby="dropdownMenu2">';
                    if (data.length === 0) {
                        dropdown += '<button class="dropdown-item" type="button">No tiene servicio</button>';
                    } else {
                        data.forEach(function(item) {
                            dropdown += '<button class="dropdown-item" type="button">' + item.nombre + '</button>';
                        });
                    }
                    return dropdown + '</div></div></div>';
                }
            },
            {"data": "idSeguro",
                render: function (data, type, row, meta) {
                    if (data === null) {
                        return "";
                    } else {
                        return data.paqueteServicio;
                    }
                }
            },
            {"defaultContent": "<div class='text-center'><div class='btn-group'><button class='btn btn-warning btn-sm text-white btnEditar' data-toggle='tooltip' data-placement='top' title='Editar Plan'><i class='bi bi-pencil-fill'></i></button><button class='btn btn-danger btn-sm btnBorrar' data-toggle='tooltip' data-placement='top' title='Eliminar Plan'><i class='bit bi-trash-fill'></i></button></div></div>"}
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

    // Peticion GET de todos los servicios 
    $.getJSON(urlEndPoint + "/servicios", function (data, textStatus, jqxhr) {
        if (jqxhr.status === 200) {
            data.forEach(function (elemento) {
                servicioList.push(Object.create({text: elemento.nombre, value: elemento.id}));
                servicioArray.push(elemento);
            });
        }
    });

    // Peticion GET de todos los seguros
    $.getJSON(urlEndPoint + "/seguros", function (data, textStatus, jqxhr) {
        if (data.length === 0) {
            $("#seguro").append('<option value="" selected disabled>--Lista de Seguro Vacia--</option>');
        } else {
            $("#seguro").append('<option value="" selected disabled>Seleccione un Seguro</option>');
            data.forEach(function (elemento) {
                $("#seguro")
                    .append('<option value="' + elemento.id + '">' + elemento.tipoServicio + '</option>');
            });
        }
    });


    //botón para agregar nuevo plan
    $("#btn-nuevo-plan").click(function () {
        opcion = 1; //alta           
        id = null;
        $("#form-plan").trigger("reset");
        $(".modal-header").css("background-color", "#007bff");
        $(".modal-title").css("color", "white");
        $(".modal-title").text("Nuevo Plan de Seguro");
        buildMultipleSelect();
        $("#btn-modal-plan").text("Guardar").css("background-color", "#007bff");
        $("#modal-plan").modal("show");
    });

    // Al abrir el modal realiza el autofocus en el primer input
    $('#modal-plan').on('shown.bs.modal', function () {
        $('#nombre').trigger('focus');
    });

    // Resetea el class del formulario y variables al cerrar el modal
    $('#modal-plan').on('hidden.bs.modal', function (event) {
        $("#form-plan").attr('class', 'needs-validation');
        $("#servicio-feedback").empty();
        arrayId = [];
        arrayServicios = [];
        selectServicios.multipleSelect('uncheckAll');
        selectServicios.multipleSelect('destroy');
    });

    // detecta el evento del cambio de un select del Seguro
    $("#seguro").change(function () {
        var id = "";
        $("#seguro option:selected").each(function () {
            id = $(this).val(); // obtiene el id y realiza una peticion GET de Seguro
            if (id !== undefined && id !== "" && id !== null) {
                getSeguro(id);
            }
        });
    });

    //botón EDITAR Plan 
    $("#tabla_planes tbody").on("click", ".btnEditar", function () {
        fila = $(this).closest("tr");
        datos = $('#tabla_planes').DataTable().row(fila).data();
        buildMultipleSelect();
        // Cuando la tabla de datos es responsive
        if (datos === undefined) {
            var selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_planes').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            $("#nombre").val(rowData.nombre);
            $("#descripcion").val(rowData.descripcion);
            rowData.serviciosList.forEach(element => arrayId.push(element.id));
            $("#seguro").val(rowData.idSeguro);
            
        } else {
            id = parseInt(datos.id); //capturo el ID
            $("#nombre").val(datos.nombre);
            $("#descripcion").val(datos.descripcion);
            datos.serviciosList.forEach(element => arrayId.push(element.id));
            $("#seguro").val(datos.idSeguro);
            console.log(datos);
        }
        selectServicios.multipleSelect('setSelects', arrayId);
        opcion = 2; //editar
        $(".modal-header").css("background-color", "orange");
        $(".modal-title").css("color", "white");
        $(".modal-title").text("Editar Plan de seguro");
        $("#btn-modal-plan").text("Editar").css("background-color", "orange");
        $("#modal-plan").modal("show");
    });

    //Borrar plan
    $("#tabla_planes tbody").on("click", ".btnBorrar", function () {
        var selected_row, nombrePlan;
        fila = $(this).closest("tr");
        datos = $('#tabla_planes').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if (datos === undefined) {
            selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_planes').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            nombrePlan = rowData.nombre;
        } else { // Cuando la tabla de datos esta en escritorio
            id = parseInt(datos.id); //capturo el ID
            nombrePlan = datos.nombre;
        }
        swal({
            title: "Estas seguro de Eliminar el plan \'" + nombrePlan + "\'",
            text: "Una vez eliminado no se prodra restablecer",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then((OK) => {
            if (OK) {
                $.ajax({
                    url: urlEndPoint + "/planes/" + id,
                    type: 'DELETE',
                    success: function (data, textStatus, jqXHR) {
                        // Cuando la tabla de datos es responsive
                        if (datos === undefined) {
                            tablaPlan.row(selected_row).remove().draw();
                        } else {
                            tablaPlan.row(fila).remove().draw();
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
    $("#form-plan").submit(function (event) {
        //evita el comportambiento normal del submit, es decir, recarga total de la página
        event.preventDefault();
        formPlan = document.getElementById("form-plan");
        if ($("#form-plan")[0].checkValidity() === false || $("#servicio").multipleSelect('getSelects').length === 0) {
            event.stopPropagation();
        } else {
            if (opcion === 1) {
                createPlan($("#nombre").val(), $("#descripcion").val());
            } else if (opcion === 2) {
                updatePlan($("#nombre").val(), $("#descripcion").val());
            }
        }
        if ($("#servicio").multipleSelect('getSelects').length === 0) {
            $("#servicio-feedback").removeClass("valid-feedback").addClass("invalid-feedback")
                    .text("Seleccione al menos un Servicio").show();
        } else {
            $("#servicio-feedback").removeClass("invalid-feedback").addClass("valid-feedback")
                    .text("Ok válido!").show();
        }
        $('#form-plan').addClass('was-validated');
    });

    function buildMultipleSelect() {
        selectServicios = $('#servicio').multipleSelect({
            placeholder: 'Seleccione Servicios',
            data: servicioList,
            filter: true,
            selectAll: true,
            minimumCountSelected: 3,
            onClick: function (view) {
                getServicio(view.value);
                servicioSeleccionado.push(view);
            },
            onClose: function () {
                servicioSelected = servicioSeleccionado.filter(object => object.selected === true);
                console.log(arrayServicios);
                if ($("#servicio").multipleSelect('getSelects').length === 0) {
                    $("#servicio-feedback").removeClass("valid-feedback").addClass("invalid-feedback")
                            .text("Seleccione al menos un Servicio").show();
                } else {
                    $("#servicio-feedback").removeClass("invalid-feedback").addClass("valid-feedback")
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
    }

    function createPlan(nombre, descripcion) {
        // Crear nuevo plan
        planObject = {nombre: nombre,
            descripcion: descripcion,
            serviciosList: arrayServicios,
            idSeguro: seguro};
        // peticion ajax post para crear un plan
        $.ajax({
            url: urlEndPoint + "/planes",
            type: "POST",
            dataType: 'JSON',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(planObject),
            success: function (data, textStatus, jqXHR) { // cuando es exitoso el insert plan
                $("#modal-plan").modal("hide");
                tablaPlan.ajax.reload(null, false);
                $("#strongToastHeader").text("Registrado");
                $(".toast-body").text(data.mensaje);
                $('#planToast').toast('show'); // mostrar notificacion
            },
            error: function (jqXHR, textStatus, errorThrown) { //Error
                if (jqXHR.status === 500) { // cuando ocurre error interno del servidor
                    responseServer = JSON.parse(jqXHR.responseText);
                    $("#modal-plan").modal("hide");
                    $('#planToast').addClass("bg-danger");
                    $("#strongToastHeader").text("Error 500");
                    $("#iToast").removeClass('bi bi-check-circle-fill').addClass('bi bi-bug-fill');
                    $(".toast-body").text(responseServer.mensaje);
                    $('#planToast').toast('show'); // mostrar notificacion
                } else if (jqXHR.status === 400) { // cuando los campos son incompleto
                    let response = JSON.parse(jqXHR.responseText);
//                        $("#descripcion-invalid").text(response.errores[0]);
//                        $("#nombre-invalid").text(response.errores[1]);
                }
            }
        });

    }

    function updatePlan(nombre, descripcion) {
        // Plan
        planObject = {nombre: nombre,
            descripcion: descripcion,
            serviciosList: arrayServicios,
            idSeguro: seguro};
        // actualizar plan
        $.ajax({
            url: urlEndPoint + "/planes/" + id,
            type: "PUT",
            dataType: "JSON",
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(planObject),
            success: function (data, textStatus, jqXHR) {
                $("#modal-plan").modal("hide");
                tablaPlan.ajax.reload(null, false);
                $("#strongToastHeader").text("Actualizado");
                $(".toast-body").text("El Plan ha sido actualizado con éxito");
                $('#planToast').toast('show');
            },
            error: function (jqXHR, textStatus, errorThrown) {
                if (jqXHR.status === 400) {
                    let response = JSON.parse(jqXHR.responseText);
//                        $("#descripcion-invalid").text(response.errores[0]);
//                        $("#nombre-invalid").text(response.errores[1]);
                } else if (jqXHR.status === 404) {

                } else if (jqXHR.status === 500) {
                    responseServer = JSON.parse(jqXHR.responseText);
                    $("#modal-plan").modal("hide");
                    $('#planToast').addClass("bg-danger");
                    $("#strongToastHeader").text("Error 500");
                    $("#iToast").removeClass('bi bi-check-circle-fill').addClass('bi bi-bug-fill');
                    $(".toast-body").text(responseServer.mensaje);
                    $('#planToast').toast('show'); // mostrar notificacion
                }
            }
        });
    }

    function getServicio(id) {
        //arrayServicios.push(servicioArray.find(object => object.value === id));
        $.getJSON(urlEndPoint + "/servicios/" + id, function (data) {
            arrayServicios.push(data);
        });
    }

    function getSeguro(id) {
        /*seguroObject = $("#seguro")[0];
         seguroObject.children.forEach(function(options) {
         console.log(options.value + ", " + options.text);
         });*/
        $.getJSON(urlEndPoint + "/seguros/" + id, function (data) {
            seguro = data;
        });
    }
});

