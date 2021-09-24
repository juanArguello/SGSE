/* 
 Created on : 20-abr-2021
 Author     : Juan Carlos Argüello Ortiz
 */

// Se despliega el menu de barra de navegacion movil
$(function () {
    'use strict';
    $('[data-toggle="offcanvas"]').on('click', function () {
        $('.offcanvas-collapse').toggleClass('open');
    });
});

// Para cerrar Sesión
$(document).ready(function () {
    $("#logout").click(function (e) {
        e.preventDefault();
        $("#logout-form").submit();
    });
});





