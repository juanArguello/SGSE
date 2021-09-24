$(document).ready(function () {
    var id, opcion;
    opcion = 4;
    tablaPermiso = $('#tabla_permisos').DataTable({ 
        "ajax":{            
            "url": "https://localhost:8443/apirest/permisos", 
            "method": 'GET', 
            "dataSrc":""
        },
        "columns":[
            {"data": "id"},
            {"data": "nombre"},
            {"data": "descripcion"},
            {"defaultContent": "<div class='text-center'><div class='btn-group'><button class='btn btn-warning btn-sm btnEditar' data-toggle='tooltip' data-placement='top' title='Editar Permiso'><i class='bi bi-pencil-fill'></i></button><button class='btn btn-danger btn-sm btnBorrar' data-toggle='tooltip' data-placement='top' title='Eliminar Permiso'><i class='bit bi-trash-fill'></i></button></div></div>"}
        ],
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

    //botón agregar nuevo permiso 
    $("#btnNuevoPermiso").click(function(){
        opcion = 1; //alta           
        id=null;
        $("#formPermiso").trigger("reset");
        $(".modal-header").css("background-color", "#28a745");
        $(".modal-title").css("color", "white");
        $(".modal-title").text("Nuevo Permiso");   
        $("#btnModalPermiso").text("Guardar").css("background-color", "#28a745");
        $("#modal-permiso").modal("show"); 
    }); 
    
    
    var fila; //capturar la fila para editar o borrar el registro
    //botón EDITAR permiso   
    $(document).on("click", ".btnEditar", function(){
        fila = $(this).closest("tr");
        id = parseInt(fila.find('td:eq(0)').text()); //capturo el ID
        nombre = fila.find('td:eq(1)').text();
        descripcion = fila.find('td:eq(2)').text();
        $("#nombre").val(nombre);
        $("#descripcion").val(descripcion);
        opcion = 2; //editar
        
        $(".modal-header").css("background-color", "orange");
        $(".modal-title").css("color", "white");
        $(".modal-title").text("Editar Permiso");  
        $("#btnModalPermiso").text("Editar").css("background-color", "orange");
        $("#modal-permiso").modal("show");   
    });
    
    //Borrar permiso
    $(document).on("click", ".btnBorrar", function(){
        fila = $(this);           
        id = parseInt($(this).closest('tr').find('td:eq(0)').text()) ;	
        swal({
            title: "Estas seguro de Eliminar?",
            text: "Una vez eliminado no se prodra restablecer!",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then((OK) => {
            if (OK) {
                $.ajax({
                    url: "https://localhost:8443/apirest/permisos/"+id,
                    type: 'DELETE',
                    success: function () {
                        tablaPermiso.row(fila.parents('tr')).remove().draw();
                        swal("Registro eliminado!", {icon: "success"});
                    },
                    error: function () {
                        swal("Error...","No se pudo Eliminar el registro!","error");
                    }
                });
            } 
        });
     });
    
    var fila; //captura la fila, para editar o eliminar
    //submit para el Alta y Actualización
    $("#formPermiso").submit(function(e){
        //evita el comportambiento normal del submit, es decir, recarga total de la página
        e.preventDefault();    
        nombre = $("#nombre").val();
        descripcion = $("#descripcion").val();
//        rolList = $("input[type=checkbox]:checked").map(function () {
//            return this.value;
//        }).get();
        if(opcion === 1){    // Crear nuevo permiso
            $.ajax({
                url: "https://localhost:8443/apirest/permisos",
                type: "POST",
                dataType: 'JSON', 
                contentType: 'application/json; charset=UTF-8',
                data:  JSON.stringify({"nombre":nombre,"descripcion": descripcion}),
                success: function(data) {
                    tablaPermiso.ajax.reload(null, false);
                }
            });
        }else if(opcion === 2){ // actualizar permiso
           $.ajax({
                url: "https://localhost:8443/apirest/permisos/"+id,
                type: "PUT",
                dataType:"JSON",
                contentType: 'application/json; charset=UTF-8',
                data:  JSON.stringify({"nombre":nombre,"descripcion": descripcion}),
                success: function(data) {
                    tablaPermiso.ajax.reload(null, false);
                }
            }); 
        }
        
        $("#modal-permiso").modal("hide"); 
    }); 

});


/* global swal */
function formPermiso() {
    swal.withForm({
    title: 'More complex Swal-Forms example',
    text: 'This has different types of inputs',
    showCancelButton: true,
    confirmButtonColor: '#DD6B55',
    confirmButtonText: 'Get form data!',
    closeOnConfirm: true,
    formFields: [
      { id: 'name', placeholder: 'Name Field' },
      { id: 'nickname', placeholder: 'Add a cool nickname' },
      { id: 'password', type: 'password' },

      { name: 'sex', value: 'Male', type: 'radio' },
      { name: 'sex', value: 'Female', type: 'radio' },

      { name: 'skills', value: 'JS', type: 'checkbox' },
      { name: 'skills', value: 'Ruby', type: 'checkbox' },
      { name: 'skills', value: 'Java', type: 'checkbox' },

      { id: 'select',
        type: 'select',
        options: [
          {value: 'test1', text: 'test1'},
          {value: 'test2', text: 'test2'},
          {value: 'test3', text: 'test3'},
          {value: 'test4', text: 'test4'},
          {value: 'test5', text: 'test5'}
        ]}
    ]
  }, function (isConfirm) {
    // do whatever you want with the form data
    console.log(this.swalForm); // { name: 'user name', nickname: 'what the user sends' }
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



