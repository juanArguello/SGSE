$(document).ready(function () {
    var id, opcion;
    var fila; //capturar la fila para editar o borrar el registro
    tablaUsuarios = $("#tabla_usuarios").DataTable({
        "ajax":{            
            "url": "https://localhost:8443/apirest/usuarios", 
            "method": 'GET', 
            "dataSrc":""
        },
        "columns":[
            {"data": "id"},
            {"data": "cedula"},
            {"data": "ruc"},
            {"data": "nombre"},
            {"data": "apellido"},
            {"data": "nombreUsuario"},
            {"data": "estado", render:function (data,type,row,meta){
                    if(data==='activo'){
                        return '<span class="btn btn-success btn-sm text-center" >'+data+'</span>';
                    }else if (data==='inactivo') {
                        return '<span class="btn btn-danger btn-sm text-center" >'+data+'</span>';
                    }  
                }
            },
            {"data": "fechaIngreso"},
            {"data": "email"},
            {"defaultContent": "<div class='text-center'><div class='btn-group'><button class='btn btn-warning btn-sm btnEditar' data-toggle='tooltip' data-placement='top' title='Editar Usuario'><i class='bi bi-pencil-fill'></i></button><button class='btn btn-danger btn-sm btnBorrar' data-toggle='tooltip' data-placement='top' title='Eliminar Usuario'><i class='bit bi-trash-fill'></i></button></div></div>"}
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
    
    
    //botón EDITAR Usuarios  
    $("#tabla_usuarios tbody").on("click", ".btnEditar", function(){
        fila = $(this).closest("tr");
        datos = $('#tabla_usuarios').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if(datos === undefined) {
            var selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_usuarios').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
        } else {
            id = parseInt(datos.id); //capturo el ID
        }
        opcion = 2; //editar
        location = "https://localhost:8443/administracion/usuario/edit/"+id;
    });
    
    //Borrar Usuario
    $("#tabla_usuarios tbody").on("click", ".btnBorrar", function(){
        var selected_row, nombreUser;
        fila = $(this).closest("tr");
        datos = $('#tabla_usuarios').DataTable().row(fila).data();
        // Cuando la tabla de datos es responsive
        if(datos === undefined) {
            selected_row = $(this).parents('tr');
            if (selected_row.hasClass('child')) {
                selected_row = selected_row.prev();
            }
            var rowData = $('#tabla_usuarios').DataTable().row(selected_row).data();
            id = parseInt(rowData.id); //capturo el ID
            nombreUser = rowData.nombreUsuario;
        } else {
            id = parseInt(datos.id); //capturo el ID
            nombreUser = datos.nombreUsuario;
        }
        swal({
            title: "Estas seguro de Eliminar el usuario "+nombreUser,
            text: "Una vez eliminado no se prodra restablecer",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then((OK) => {
            if (OK) {
                $.ajax({
                    url: "https://localhost:8443/apirest/usuarios/"+id,
                    type: 'DELETE',
                    success: function () {
                        // Cuando la tabla de datos es responsive
                        if(datos === undefined) {
                            tablaUsuarios.row(selected_row).remove().draw();
                        }else {
                           tablaUsuarios.row(fila).remove().draw();
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
});    
 




