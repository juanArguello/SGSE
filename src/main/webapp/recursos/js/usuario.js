$(document).ready(function () {
    tablaUsuarios = $("#tabla_usuarios").DataTable({
        "scrollX": true,
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
});    
 
function eliminarUsuario(id) {
    swal({
        title: "Estas seguro de Eliminar?",
        text: "Una vez eliminado no se prodra restablecer!",
        icon: "warning",
        buttons: true,
        dangerMode: true
    }).then((OK) => {
        if (OK) {
            $.ajax({
                url: "/administracion/eliminar-permiso/"+id,
                success: function (response) {
                    console.log(response);
                }
            });
            swal("Registro eliminado!", {
                icon: "success"
            }).then((ok)=>{
                if (ok){
                    location.href="/administracion";
                }
            });
        } else {
            swal("El registro no se pudo eliminar!");
        }
    });
}




// // Consumir api REST de usuarios con el metodo GET
//$(document).ready(function () {
//    $.ajax({
//        type: 'GET',
//        url: "https://localhost:8443/apirest/permisos",
//        dataType: 'json',
//        success: function (datos) {
//            var filas_permisos = '';
//            $.each(datos, function (i, item) {
//                filas_permisos += '<tr>';
//                filas_permisos += '<td>' + item.id + '</td>';
//                filas_permisos += '<td>' + item.nombre + '</td>';
//                filas_permisos += '<td>' + item.descripcion + '</td>';
//                filas_permisos += '<td class="text-center">'; 
//                filas_permisos += '<a id="'+i+'" href="/administracion/edit-permiso" class="btn-warning">Editar</a>';      
//                filas_permisos += ' <a id="'+i+'" onClick="confirmDeletePermiso('+item.id+')" class="btn-danger">Eliminar</a>';       
//                filas_permisos += '</td></tr>';
//            });
//            $("#tabla_permisos").append(filas_permisos);
//        },
//        error: function (error) {
//            alert(error);
//        }
//    });
//});

//// obtiene rol 
//function getRol(idRol) {
//    return idRol.descripcion;
//}
//function getCadenaVacia(objecto) {
//    if (objecto === null) {
//        return "-----";
//    } else {
//        return objecto;
//    }
//}
//function confirmDeletePermiso(idPermiso) {
//    $("#modal_delete_permiso").modal("show");
//    var confirmado = document.getElementById("#confirmado_del_permiso");
//    confirmado.click(
//        $.ajax({
//        type: 'DELETE',
//        url: "https://localhost:8443/apirest/permisos/"+idPermiso,
//        success: function (data, textStatus, jqXHR) {
//            
//        }
//        })    
//    );
//}