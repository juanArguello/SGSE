$(document).ready(function () {
    let urlEndPoint = sessionStorage.getItem("urlEndPoint");
    let urlRoot = sessionStorage.getItem("urlRoot");
    //Bootstrap Duallistbox
    var bootstrapDualListbox = $('.duallistbox').bootstrapDualListbox({
        filterTextClear: 'Mostrar todo',
        filterPlaceHolder: 'Filtrar',
        moveSelectedLabel: 'Mover seleccionado',
        moveAllLabel: 'Mover todo',
        removeSelectedLabel: 'Remover selección',
        removeAllLabel: 'Remover todo',
        infoText: 'Mostrar {0}',
        infoTextFiltered: '<span class="badge badge-warning">Filtrado</span> {0} de {1}',
        infoTextEmpty: 'Lista Vacia',
        nonSelectedListLabel: 'No Seleccionado',
        selectedListLabel: 'Seleccionado'
    });
    
    var arrayPermisos = new Array(); // array de permisos
    var arrayUsuarios = new Array(); // array de Usuarios
    var path = location.pathname;
    pathArray = path.split("/");
    idRequest = pathArray[pathArray.length-1];
    
    $.getJSON(urlEndPoint+"/roles/"+idRequest,function(data){
        if(data.usuarioList.length > 0){
            $.each(data.usuarioList,function(i,item) {
                arrayUsuarios.push(item);
            });
        }
    }); 
    
    
    $('#confirm-permiso').on('click', function() {
        if($(this).is(':checked')){
            // Obtener los permisos si el checkboxes ha sido seleccionado
            $.each($("#listaPermisos").val(),function(i,id){
                getPermisos(id);
            });
        } else {
            // Hacer algo si el checkbox ha sido deseleccionado
            
        }
    });
    
   
    $("#editar-rol").submit(function (e) {
        e.preventDefault();
        nombre = $("#nombre").val();
        descripcion = $("#descripcion").val();
        // Bucle sobre ellos y evitar el submit
        $.each($("#editar-rol"), function (i, item) {
            if(item.checkValidity() === false){
                e.stopPropagation();
            }
            item.classList.add('was-validated');
        });
        if( $('#confirm-permiso').is(':checked') && arrayPermisos.length !== 0 ) {
            updateRol(nombre,descripcion);
        }else{
            $("label.form-check-label").addClass("text-danger");
        }  
    });
    
    function updateRol(nombre,descripcion){
        
        // datos del rol en formato object javascript
        rolObject = {nombre: nombre,descripcion: descripcion,permisosList : arrayPermisos, 
                    usuarioList : arrayUsuarios}; 
        
        // peticion ajax de actualizacion   
        $.ajax({
            url: urlEndPoint+"/roles/"+idRequest,
            type: "PUT",
            dataType: 'JSON',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(rolObject),
            success: function (data, textStatus, jqXHR) { // cuando es exitoso el update del rol
                location = urlRoot+"/administracion/roles";
            },
            error: function (jqXHR, textStatus, errorThrown) { //Error
                if (jqXHR.status === 500) { // cuando ocurre error interno del servidor
                    responseServer = JSON.parse(jqXHR.responseText);
                    $('#add-rol-Toast').addClass("bg-danger");
                    $("#strongToastHeader").text("Error 500");
                    $(".toast-body").text(responseServer.mensaje);
                    $('#add-rol-Toast').toast('show'); // mostrar notificacion
                }else if(jqXHR.status === 400){ // cuando los campos son incompleto
                    response = JSON.parse(jqXHR.responseText);
                    $("#nombre-invalid").text(response.errores[0]);
                    $("#descripcion-invalid").text(response.errores[2]);
                   
                }   
            }
        });
    }

    function getPermisos(id) {
        // realiza la peticion ajax para obtener permiso de acuerdo al id
        $.getJSON(urlEndPoint+"/permisos/"+id,function(data){
            arrayPermisos.push(data);
        });
         
    }
    
});

