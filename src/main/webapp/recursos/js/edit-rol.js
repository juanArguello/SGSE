$(document).ready(function () {
    //Bootstrap Duallistbox
    bootstrapDualListbox = $('.duallistbox').bootstrapDualListbox({
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
    
    
    
    $("#editar-rol").submit(function (e) {
        e.preventDefault();
        nombre = $("#nombre").val();
        descripcion = $("#descripcion").val();
        listaId = $("#listaPermisos").val();
        rolString = JSON.stringify({"nombre": nombre, "descripcion": descripcion, "permisosList": [], "usuarioList": []});
        listaPermisos = getPermisos(listaId);
        rolObject = JSON.parse(rolString);
        rolObject["permisosList"] = listaPermisos;
        rolString = JSON.stringify(rolObject);

        console.log(rolObject);
        console.log(rolString);
        $.ajax({
            url: "https://localhost:8443/apirest/roles",
            type: "POST",
            dataType: 'JSON',
            contentType: 'application/json; charset=UTF-8',
            data: rolString,
            success: function (data) {
                //location = "roles";
            }
        });
    });

    function getPermisos(listaId) {
        arrayPermisos = new Array();
        $.each(listaId, function (i, id) {
            $.getJSON("https://localhost:8443/apirest/permisos/" + id, function (data) {
                arrayPermisos.push(data);
            });
        });
        return arrayPermisos;
    }
});

