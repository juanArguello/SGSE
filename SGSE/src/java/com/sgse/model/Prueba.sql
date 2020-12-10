SELECT * FROM usuario ORDER BY id;

SELECT * FROM rol ORDER BY id;

SELECT * FROM rol_permisos ORDER BY id_rol,id_permisos;

select nombre_usuario as username,contrasenha as password,	case estado
                        when 'activo' then true
                        else false end 
                    from usuario where nombre_usuario = 'juan';

SELECT * FROM permisos ORDER BY id;

INSERT INTO permisos(id,nombre,descripcion) VALUES(112,'crear usuario','Crea un nuevo usuario en el sistema');
INSERT INTO permisos(id,nombre,descripcion) VALUES(113,'modificar usuario','Modificar datos de los usuarios');
INSERT INTO permisos(id,nombre,descripcion) VALUES(114,'eliminar usuario','Dar de baja y/o eliminar a usuarios');
INSERT INTO permisos(id,nombre,descripcion) VALUES(115,'consultar a usuarios','Consulta los datos de usuarios');
INSERT INTO permisos(id,nombre,descripcion) VALUES(116,'crear permisos','Crea un nuevo permiso en el sistema');
INSERT INTO permisos(id,nombre,descripcion) VALUES(117,'modificar permisos','Modificar los campos de los permisos');
INSERT INTO permisos(id,nombre,descripcion) VALUES(118,'eliminar permisos','Elimina permisos en el sistema');
INSERT INTO permisos(id,nombre,descripcion) VALUES(119,'consultar permisos','Consulta los permisos disponibles');
INSERT INTO permisos(id,nombre,descripcion) VALUES(120,'crear rol','Crea un nuevo rol en el sistema');
INSERT INTO permisos(id,nombre,descripcion) VALUES(121,'modificar rol','Modificar los campos del rol');
INSERT INTO permisos(id,nombre,descripcion) VALUES(122,'eliminar rol','Elimina rol en el sistema');
INSERT INTO permisos(id,nombre,descripcion) VALUES(123,'consultar rol','Consulta los roles disponibles');
INSERT INTO permisos(id,nombre,descripcion) VALUES(124,'asignar permisos a roles','Permite asignar permisos a uno o varios roles');
INSERT INTO permisos(id,nombre,descripcion) VALUES(125,'asignar rol a usuario','Permite asignar rol a Usuarios');
INSERT INTO permisos(id,nombre,descripcion) VALUES(126,'quitar permisos a rol','Permite quitar permisos de un rol');
INSERT INTO permisos(id,nombre,descripcion) VALUES(127,'quitar rol a usuario','Permite quitar rol de un usuario');
INSERT INTO permisos(id,nombre,descripcion) VALUES(128,'visualizar el dashboard home',' Se visualiza el dashboard al iniciar con los botones de acceso a los modulos');
INSERT INTO permisos(id,nombre,descripcion) VALUES(,'','');
INSERT INTO permisos(id,nombre,descripcion) VALUES(,'','');


UPDATE permisos SET descripcion = 'Se visualiza el dashboard al iniciar con los botones de acceso a los modulos'
WHERE id = 128;
COMMIT;