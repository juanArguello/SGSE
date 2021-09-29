/*  ADMINISTRADOR                               VENDEDOR
    user:        jarguello                      user:        jortiz
    password:    gvpkGljB                       password:    rA5KMGtw
    correo:     juanarguello092@gmail.com       correo:      juanarguello092@fpuna.edu.py
*/
SELECT * FROM usuario ORDER BY id;
SELECT * FROM rol ORDER BY id;
SELECT * FROM permisos ORDER BY id;
SELECT * FROM rol_permisos ORDER BY id;

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