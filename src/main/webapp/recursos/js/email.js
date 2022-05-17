$(document).ready(function () {
    
    let urlEndPoint = sessionStorage.getItem("urlEndPoint");
    $("#summernote").summernote({
        placeholder: 'Cuerpo del Mensaje',
        tabsize: 2,
        height: 120,
        lang: "es-ES"
    });
    
    $("#email_cliente").on("click", function (event) {
        $("#bodyModalEmail").empty();
        $("#tituloModalEmail").text("Lista de Direcciones de Clientes");
        $.getJSON(urlEndPoint+"/clientes", function (data) {
            var filasEmailCliente = '';
            $.each(data, function (i, item) {
                filasEmailCliente += '<tr>';
                filasEmailCliente += '<td>' + item.cedula + '</td>';
                filasEmailCliente += '<td>' + item.nombre + ' ' + item.apellido + '</td>';
                filasEmailCliente += '<td>' + item.email + '</td>';
                filasEmailCliente += '</tr>';
            });
            $("#bodyModalEmail").append(filasEmailCliente);
            $("#listaEmailModal").modal("show");
        });

        });
        $("#email_user").on("click", function (event) {
            $("#bodyModalEmail").empty();
            $("#tituloModalEmail").text("Lista de Direcciones de Usuarios");
            $.getJSON(urlEndPoint+"/usuarios", function (data) {
                var filasEmailUser = '';
                $.each(data, function (i, item) {
                    filasEmailUser += '<tr>';
                    filasEmailUser += '<td>' + item.cedula + '</td>';
                    filasEmailUser += '<td>' + item.nombre + ' ' + item.apellido + '</td>';
                    filasEmailUser += '<td>' + item.email + '</td>';
                    filasEmailUser += '</tr>';
                });
                $("#bodyModalEmail").append(filasEmailUser);
                $("#listaEmailModal").modal("show");
            });

        });

        
        $('#listaEmailModal').on('shown.bs.modal', function () {
            $("#bodyModalEmail tr").click(function (e) {
                var email = $(this).find("td:eq(2)").text();
                $("#correo").val(email);
                $("#listaEmailModal").modal("hide");
            });
        });

        $("input:file").change(function () {
            var fileName = $(this).val();
            $(".custom-file-label").html("Archivo: " + fileName);
        });


        $("#emailForm").submit(function (event) {
            event.preventDefault();
            $('#summernote').html($('#summernote').code());
            if ($("#emailForm")[0].checkValidity() === false) {
                event.stopPropagation();
            } else {
                $("#btnSubmitEmail").prop("disabled", true); //deshabilitamos el botón
                //añadimos el spinner
                $("#btnSubmitEmail").html('<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Enviando...');
                $("#cabecera").removeClass("card-title").addClass("d-flex justify-content-center");
                $("#cabecera").html('<div class="spinner-border  text-info" role="status">'+
                    '<span class="sr-only">Loading...</span></div>'+
                    ' <h5 class="card-title  text-info"> Enviando...</h5>');
                $(this).submit();
            }
            $('#emailForm').addClass('was-validated');

        });


});


