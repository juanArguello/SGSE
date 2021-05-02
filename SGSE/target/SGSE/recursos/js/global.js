/* 
    Created on : 20-abr-2021
    Author     : Juan Carlos Argüello Ortiz
*/

// Para cerrar Sesión
$(document).ready(function () {
    $("#logout").click(function (e) {
        e.preventDefault();
        $("#logout-form").submit();
    });
});

$(function () {
    'use strict';
    $('[data-toggle="offcanvas"]').on('click', function () {
        $('.offcanvas-collapse').toggleClass('open');
    });
});

