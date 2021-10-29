/*  ADMINISTRADOR                               VENDEDOR
    user:        jarguello                      user:        jortiz
    password:    gvpkGljB                       password:    9vouxZvQ
    correo:     juanarguello092@gmail.com       correo:      juanarguello092@fpuna.edu.py
*/
SELECT * FROM usuario ORDER BY id;
SELECT * FROM rol ORDER BY id;
SELECT * FROM permisos ORDER BY id;
SELECT * FROM rol_permisos;
SELECT * FROM cliente ORDER BY id;


UPDATE usuario SET estado = 'activo' WHERE id = 2;



INSERT INTO rol (id,nombre, descripcion) VALUES(29,'a','b');


$.ajax({
    url: "https://localhost:8443/apirest/roles",
    type: "POST",
    dataType: 'JSON', 
    contentType: 'application/json; charset=UTF-8',
    data:  rolString,
    success: function(data) {
        location = "roles";
    }
});







-- <div class="footer text-center" style="margin-top: 75px ">
--     Copyright &copy; 2021 &mdash; Futuro 
-- </div>

-- <link   type="image/x-icon"
--     rel="icon" href="<c:out value='${pageContext.request.contextPath}/recursos/images/favicon.png'/>"
-- />

-- <link rel="shortcut icon" href="<c:out value='${pageContext.request.contextPath}/recursos/images/logo.ico'/>"
--       type="image/x-icon" />


--     <link rel="shortcut icon" href="<c:out value='/WEB-INF/recursos/images/logo.ico'/>"
--           type="image/x-icon"/>

--     rolList = $("input[type=checkbox]:checked").map(function () {
--        return this.value;
--     }).get();


-- <select  id="listaRoles" list="rolList" class="form-control">
--     <option selected disabled>Seleccione el rol</option>
--     <c:forEach items="${roles}" var="rol">
--         <option value="${rol.nombre}"><c:out value="${rol.nombre}"/></option>
--     </c:forEach> 
-- </select>

-- <div class="form-group"> 
--     <label for="rolList" class="col-form-label">Asociar Rol: </label><br>
--     <c:forEach items="${roles}" var="rol">
--         <div class="form-check form-check-inline">
--             <input type="checkbox" class="form-check-input" 
--                 name="rolCheckbox" value="${rol.id}" />
--             <label class="form-check-label" for="${rol.nombre}">
--                 <c:out value="${rol.nombre}"/>
--             </label>
--         </div>
--     </c:forEach> 
-- </div>


-- Consumir api REST de usuarios con el metodo GET
-- $(document).ready(function () {
--     $.ajax({
--         type: 'GET',
--         url: "https://localhost:8443/apirest/permisos",
--         dataType: 'json',
--         success: function (datos) {
--             var filas_permisos = '';
--             $.each(datos, function (i, item) {
--                 filas_permisos += '<tr>';
--                 filas_permisos += '<td>' + item.id + '</td>';
--                 filas_permisos += '<td>' + item.nombre + '</td>';
--                 filas_permisos += '<td>' + item.descripcion + '</td>';
--                 filas_permisos += '<td class="text-center">'; 
--                 filas_permisos += '<a id="'+i+'" href="/administracion/edit-permiso" class="btn-warning">Editar</a>';      
--                 filas_permisos += ' <a id="'+i+'" onClick="confirmDeletePermiso('+item.id+')" class="btn-danger">Eliminar</a>';       
--                 filas_permisos += '</td></tr>';
--             });
--             $("#tabla_permisos").append(filas_permisos);
--         },
--         error: function (error) {
--             alert(error);
--         }
--     });
-- });
-- 
--  obtiene rol 
-- function getRol(idRol) {
--     return idRol.descripcion;
-- }
-- function getCadenaVacia(objecto) {
--     if (objecto === null) {
--         return "-----";
--     } else {
--         return objecto;
--     }
-- }
-- function confirmDeletePermiso(idPermiso) {
--     $("#modal_delete_permiso").modal("show");
--     var confirmado = document.getElementById("#confirmado_del_permiso");
--     confirmado.click(
--         $.ajax({
--         type: 'DELETE',
--         url: "https://localhost:8443/apirest/permisos/"+idPermiso,
--         success: function (data, textStatus, jqXHR) {
--             
--         }
--         })    
--     );
-- }


--    $("#formPermiso").validate({
--        rules: {
--            nombre: {
--                required: true
--            },
--            descripcion: {
--                required: true
--            }
--        },
--        messages: {
--            nombre: {
--                required: "Por favor ingrese un nombre"
--            },
--            descripcion: {
--                required: "Por favor ingrese la descripcion"
--            }
--        },
--        errorElement: 'span',
--        errorPlacement: function (error, element) {
--        error.addClass('invalid-feedback');
--        element.closest('.form-group').append(error);
--        },
--        highlight: function (element, errorClass, validClass) {
--            $(element).addClass('is-invalid');
--        },
--        unhighlight: function (element, errorClass, validClass) {
--            $(element).removeClass('is-invalid');
--        }
--    });