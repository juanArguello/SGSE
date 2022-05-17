$(document).ready(function () {
    var id, opcion;
    var fila; //capturar la fila para editar o borrar el registro
    let urlEndPoint = sessionStorage.getItem("urlEndPoint");
    var tablaServicios = $("#tabla_servicios").DataTable({
        "ajax":{            
            "url": urlEndPoint+"/servicios", 
            "method": 'GET', 
            "dataSrc":""
        },
        "columns":[
            {"data": "id"},
            {"data": "nombre"},
            {"data": "descripcion"},
            {"data": "planList", render:function (data,type,row,meta){
                if(data.length > 0){
                    return '<div class="text-center"><button class="btn btn-info btn-sm text-center btn-plan" data-toggle="tooltip" data-placement="top" title="Ver Planes">'+data.length+' Planes</button></div>';
                }else if (data.length===0) {
                    return '<div class="text-center"><span class="btn btn-danger btn-sm" >Plan asociado: '+data.length+'</span></div>';
                }  
            }
            },
            {"defaultContent": "<div class='text-center'><div class='btn-group'><button class='btn btn-warning btn-sm text-white btnEditar' data-toggle='tooltip' data-placement='top' title='Editar Servicio'><i class='bi bi-pencil-fill'></i></button><button class='btn btn-danger btn-sm btnBorrar' data-toggle='tooltip' data-placement='top' title='Eliminar Servicio'><i class='bit bi-trash-fill'></i></button></div></div>"}
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
    
    
    
    // Al abrir el modal realiza el autofocus en el primer input
    $('#modal-servicio').on('shown.bs.modal', function () {
        $('#nombre').trigger('focus');
    });
    
    // Resetea el class del formulario al cerrar el modal
    $('#modal-servicio').on('hidden.bs.modal', function (event) {
        $("#form-servicio").attr('class', 'needs-validation');
    });
    
    // Resetea los datos de la lista de planes al cerrar el modal
    $('#lista-planes-modal').on('hidden.bs.modal', function (event) {
        $("#titulo-modal-planes").empty();
        $("#body-modal-plan").empty();
    });
    
    //ver los planes 
    $("#tabla_servicios tbody").on("click", ".btn-plan", function(){
        fila = $(this).closest("tr");
        datosServicio = $('#tabla_servicios').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if(datosServicio === undefined) {
            var selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            let  rowData = $('#tabla_servicios').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            nombre = rowData.nombre;
            $("#titulo-modal-planes").text("Lista de planes del Servicio "+nombre);
            $.ajax({
                url: urlEndPoint+"/servicios/"+id,
                type: 'GET',
                success: function (datos) {
                    let  filasPlanes = '';
                    $.each(datos.planList, function (i, item) {
                        filasPlanes += '<tr>';
                        filasPlanes += '<td>' + item.id + '</td>';
                        filasPlanes += '<td>' + item.nombre + '</td>';
                        filasPlanes += '<td>' + item.descripcion + '</td>';
                        filasPlanes += '</tr>';
                    });
                    $("#bodyModalPermiso").append(filasPlanes);
                }
            });
        } else { // Cuando la tabla de datos esta en forma escritorio
            $("#titulo-modal-planes").text("Lista de planes del Servicio "+datosServicio.nombre);
            let  filasPlanes = '';
            $.each(datosServicio.planList, function (i, item) {
                filasPlanes += '<tr>';
                filasPlanes += '<td>' + item.id + '</td>';
                filasPlanes += '<td>' + item.nombre + '</td>';
                filasPlanes += '<td>' + item.descripcion + '</td>';
                filasPlanes += '</tr>';
            });
            $("#bodyModalPermiso").append(filasPlanes);
        }
        $("#lista-planes-modal").modal("show");
    });
    
    //botón agregar nuevo permiso 
    $("#btn-nuevo-servicio").click(function () {
        opcion = 1; //alta           
        id = null;
        $("#form-servicio").trigger("reset");
        $(".modal-header").css("background-color", "#28a745");
        $(".modal-title").css("color", "white");
        $(".modal-title").text("Nuevo Servicio");
        $("#btnModalServicio").text("Guardar").css("background-color", "#28a745");
        $("#modal-servicio").modal("show");
    });
    
    //botón EDITAR servicio 
    $("#tabla_servicios tbody").on("click", ".btnEditar", function () {
        fila = $(this).closest("tr");
        datos = $('#tabla_servicios').DataTable().row(fila).data();
        let datosForm;
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
        $("#nombre").val(datosForm.nombre);
        $("#descripcion").val(datosForm.descripcion);
        
       
        $(".modal-header").css("background-color", "orange");
        $(".modal-title").css("color", "white");
        $(".modal-title").text("Editar Servicios");
        $("#btnModalServicio").addClass("bi bi-save2");
        $("#btnModalServicio").text(" Guardar cambios").css("background-color", "orange");
        
        $("#modal-servicio").modal("show");
    });
    
    
    //submit para el Alta y Actualización
    $("#form-servicio").submit(function (event) {
        //evita el comportambiento normal del submit, es decir, recarga total de la página
        event.preventDefault();
        let nombre = $("#nombre").val();
        let descripcion = $("#descripcion").val();
        let formServicios = document.getElementById("form-servicio");
        if(formServicios.checkValidity() === false){
            event.stopPropagation();
        }else {
            createOrUpdateServicio(nombre,descripcion);
        }
        $('#form-servicio').addClass('was-validated');
    });
    
    
    
    function createOrUpdateServicio(nombre,descripcion){
        if (opcion === 1) {    // Crear nuevo servicio
            // datos del servicio en formato object javascript
            servicioObject = {nombre: nombre, descripcion: descripcion};
            $.ajax({
                url: urlEndPoint+"/servicios",
                type: "POST",
                dataType: 'JSON',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(servicioObject),
                success: function (data, textStatus, jqXHR) { // cuando es exitoso el insert permiso
                    $("#modal-servicio").modal("hide");
                    tablaServicios.ajax.reload(null, false);
                    $("#servicioToastHeader").text("Registrado");
                    $(".toast-body").text(data.mensaje);
                    $('#servicio-toast').toast('show'); // mostrar notificacion
                },
                error: function (jqXHR, textStatus, errorThrown) { //Error
                    if (jqXHR.status === 500) { // cuando ocurre error interno del servidor
                        responseServer = JSON.parse(jqXHR.responseText);
                        $("#modal-servicio").modal("hide");
                        $('#servicio-toast').addClass("bg-danger");
                        $("#servicioToastHeader").text("Error 500");
                        $("#iToast-service").removeClass('bi bi-check-circle-fill').addClass('bi bi-bug-fill');
                        $(".toast-body").text(responseServer.mensaje);
                        $('#servicio-toast').toast('show'); // mostrar notificacion
                    }else if(jqXHR.status === 400){ // cuando los campos son incompleto
                        let response = JSON.parse(jqXHR.responseText);
//                        $("#descripcion-invalid").text(response.errores[0]);
//                        $("#nombre-invalid").text(response.errores[1]);
                    }   
                }
            });
        } else if (opcion === 2) { // actualizar servicios
            $.ajax({
                url: urlEndPoint+"/servicios/"+id,
                type: "PUT",
                dataType: "JSON",
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify({"nombre": nombre, "descripcion": descripcion}),
                success: function (data, textStatus, jqXHR) {
                    $("#modal-servicio").modal("hide");
                    tablaServicios.ajax.reload(null, false);
                    $("#servicioToastHeader").text("Actualizado");
                    $(".toast-body").text("El Servicio ha sido actualizado con éxito");
                    $('#servicio-toast').toast('show'); // notificacion de servicio actualizado
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    if (jqXHR.status === 400) {
                        let response = JSON.parse(jqXHR.responseText);
//                        $("#descripcion-invalid").text(response.errores[0]);
//                        $("#nombre-invalid").text(response.errores[1]);
                    }else if(jqXHR.status === 404) {
                        
                    }else if(jqXHR.status === 500) {
                        responseServer = JSON.parse(jqXHR.responseText);
                        $("#modal-servicio").modal("hide");
                        $('#servicio-toast').addClass("bg-danger");
                        $("#servicioToastHeader").text("Error 500");
                        $("#iToast-service").removeClass('bi bi-check-circle-fill').addClass('bi bi-bug-fill');
                        $(".toast-body").text(responseServer.mensaje);
                        $('#servicio-toast').toast('show'); // mostrar notificacion
                    }

                }
            });
        }   
    }
    
    //Borrar servicios
    $("#tabla_servicios tbody").on("click", ".btnBorrar", function(){
        var selected_row;
        fila = $(this).closest("tr");
        datos = $('#tabla_servicios').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if(datos === undefined) {
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
            title: "Estas seguro de Eliminar el Servicio "+nombre,
            text: "Una vez eliminado no se prodra restablecer",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then((OK) => {
            if (OK) {
                $.ajax({
                    url: urlEndPoint+"/servicios/"+id,
                    type: 'DELETE',
                    success: function () {
                        // Cuando la tabla de datos es responsive
                        if(datos === undefined) {
                            tablaServicios.row(selected_row).remove().draw();
                        }else {
                           tablaServicios.row(fila).remove().draw();
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
     
     function visualizarUsuarioDetalle(id){
        $("#tituloUser").empty();
        $("#bodyModalUsuario").empty();
        $.getJSON(urlEndPoint+"/usuarios/"+id,function(data) {
            $("#tituloUser").text("Datos del Usuario: "+data.nombreUsuario);
            $("#bodyModalUsuario").append(rellenarDatosUser(data));
            $("#modal-usuario-detalle").modal("show");                   
        });
     }
     
     function rellenarDatosUser(data){
        var userDetails = '';
        atributos = Object.keys(data);
        valores = Object.values(data);
        $.each(atributos,function (i,item) {
            if(item=="idRol") {
                userDetails += '<tr>';
                userDetails += '<td class="font-weight-bold">Rol:        </td>';
                userDetails += '<td>' + valores[i].nombre + '</td>';
                userDetails += '</tr>';
            }else if(valores[i]==null) {
                userDetails += '<tr>';
                userDetails += '<td class="font-weight-bold">'+capitalizarPrimeraLetra(item)+':        </td>';
                userDetails += '<td></td>';
                userDetails += '</tr>';
            }else {
                userDetails += '<tr>';
                userDetails += '<td class="font-weight-bold">'+capitalizarPrimeraLetra(item)+':        </td>';
                userDetails += '<td>' + valores[i] + '</td>';
                userDetails += '</tr>';
            } 
            
        });
        return userDetails;
     }
     
    function capitalizarPrimeraLetra(str) {
        return str.charAt(0).toUpperCase() + str.slice(1);
    }
});    
 




