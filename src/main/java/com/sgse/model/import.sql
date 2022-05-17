/* Populate tabla Roles */
INSERT INTO rol (id,nombre,descripcion) VALUES (1,'ROLE_ADMIN','Administrador del sistema');
INSERT INTO rol (id,nombre,descripcion) VALUES (2,'ROLE_VEND','Vendedor externo');
INSERT INTO rol (id,nombre,descripcion) VALUES (3,'ROLE_CONT','Contador');
INSERT INTO rol (id,nombre,descripcion) VALUES (4,'ROLE_AUDT','Auditor');

/* Populate tabla Permisos */
INSERT INTO permisos (id,nombre,descripcion) VALUES (111,'login','Iniciar sesion en el sistema');
INSERT INTO permisos (id,nombre,descripcion) VALUES (112,'crear usuario','Crea un nuevo usuario en el sistema');
INSERT INTO permisos (id,nombre,descripcion) VALUES (113,'modificar usuario','Modificar datos de los usuarios');
INSERT INTO permisos (id,nombre,descripcion) VALUES (114,'eliminar usuario','Dar de baja y/o eliminar a usuarios');
INSERT INTO permisos (id,nombre,descripcion) VALUES (115,'consultar a usuarios','Consulta los datos de usuarios');
INSERT INTO permisos (id,nombre,descripcion) VALUES (116,'crear permisos','Crea un nuevo permiso en el sistema');
INSERT INTO permisos (id,nombre,descripcion) VALUES (117,'modificar permisos','Modificar los campos de los permisos');
INSERT INTO permisos (id,nombre,descripcion) VALUES (118,'eliminar permisos','Elimina permisos en el sistema');
INSERT INTO permisos (id,nombre,descripcion) VALUES (119,'consultar permisos','Consulta los permisos disponibles');
INSERT INTO permisos (id,nombre,descripcion) VALUES (120,'crear rol','Crea un nuevo rol en el sistema');
INSERT INTO permisos (id,nombre,descripcion) VALUES (121,'modificar rol','Modificar los campos del rol');
INSERT INTO permisos (id,nombre,descripcion) VALUES (122,'eliminar rol','Elimina rol en el sistema');
INSERT INTO permisos (id,nombre,descripcion) VALUES (123,'consultar rol','Consulta los roles disponibles');
INSERT INTO permisos (id,nombre,descripcion) VALUES (124,'asignar permisos a roles','Permite asignar permisos a uno o varios roles');
INSERT INTO permisos (id,nombre,descripcion) VALUES (125,'asignar rol a usuario','Permite asignar rol a Usuarios');
INSERT INTO permisos (id,nombre,descripcion) VALUES (126,'quitar permisos a rol','Permite quitar permisos de un rol');
INSERT INTO permisos (id,nombre,descripcion) VALUES (127,'quitar rol a usuario','Permite quitar rol de un usuario');
INSERT INTO permisos (id,nombre,descripcion) VALUES (128,'visualizar el dashboard home','Se visualiza el dashboard al iniciar con los botones de acceso a los modulos');


INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,111);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (2,111);		
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (3,111);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,128);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (2,128);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (3,128);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,112);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,113);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,114);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,115);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,116);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,117);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,118);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,119);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,120);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,121);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,122);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,123);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,124);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,125);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,126);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (1,127);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (4,128);
INSERT INTO rol_permisos (id_rol, id_permisos) VALUES (4,111);




INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(1, 'Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(2, 'Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(3, 'Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(3, 'Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(3, 'John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(3, 'Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(5, 'Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(6, 'Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(7, 'Jade', 'Doe', 'jane.doe@gmail.com', '2018-03-06');

/* Creamos algunos usuarios con sus roles */
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('andres','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',1, 'Andres', 'Guzman','profesor@bolsadeideas.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1, 'John', 'Doe','jhon.doe@bolsadeideas.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());

INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);
