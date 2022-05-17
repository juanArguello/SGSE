/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
export const dominio = "hola mundo";


$.getScript("https://localhost:8443/recursos/js/dominio.js", function(data, textStatus, jqxhr) {
    console.log(data); //data returned
    console.log(textStatus); //success
    console.log(jqxhr.status); //200
 });