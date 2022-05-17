$(document).ready(function () {
    var tablaClientes;
    let urlEndPoint = sessionStorage.getItem("urlEndPoint");
    
    
    
    window.onbeforeunload = function(e) {
        $("#nuevoNombreCliente").attr("placeholder","Nombres y Apellidos").val("");
        $("#cedula").attr("placeholder","Nº de Cedula").val("");
        $("#ruc").attr("placeholder","RUC").val("");
        $("#telefono").attr("placeholder","Telefono").val("");
    };
    
    $("#buscar_cliente").click(function () {
        requestClientes();
    });
    
    // Destruye el DataTable al cerrar el modal
    $('#listaClientesModal').on('hidden.bs.modal', function(event) {
        tablaClientes.destroy();
    });

    function requestClientes() {
        tablaClientes = $('#tabla_lista_clientes').DataTable({
            "ajax": {
                "url": urlEndPoint+"/clientes",
                "method": 'GET',
                "dataSrc": ""
            },
            "columns": [
                {"data": "cedula"},
                {"data": "ruc"},
                {"data": "nombre"},
                {"data": "apellido"},
                {"data": "telefono"}
            ],
            responsive: true,
            select: true,
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
        $("#listaClientesModal").modal("show");
    }

    $('#tabla_lista_clientes tbody').on('click', 'tr', function () {
        if($(this).hasClass('selected')) {
            data = tablaClientes.row('.selected').data();
            $(this).removeClass('selected');
            rellenarInputsCliente(data);
            
        }
        else {
            //tablaUsuarios.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
    
    function rellenarInputsCliente(data){
        nuevoNombreCliente = $("#nuevoNombreCliente").removeAttr("readonly")
            .val(data.nombre+' '+data.apellido);
        cedula = $("#cedula").removeAttr("readonly").val(data.cedula);
        ruc = $("#ruc").removeAttr("readonly").val(data.ruc);
        telefono = $("#telefono").removeAttr("readonly").val(data.telefono);
        nuevoNombreCliente.attr("readonly","on");
        cedula.attr("readonly","on");
        ruc.attr("readonly","on");
        telefono.attr("readonly","on");
        $("#listaClientesModal").modal("hide");
     }


});

