package com.sgse.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> ruc;
	public static volatile SingularAttribute<Usuario, String> estado;
	public static volatile SingularAttribute<Usuario, Rol> idRol;
	public static volatile SingularAttribute<Usuario, Integer> cedula;
	public static volatile SingularAttribute<Usuario, String> direccion;
	public static volatile ListAttribute<Usuario, ContratoVenta> contratoVentaList;
	public static volatile SingularAttribute<Usuario, String> nombreUsuario;
	public static volatile ListAttribute<Usuario, RegistrarVenta> registrarVentaList;
	public static volatile SingularAttribute<Usuario, String> nombre;
	public static volatile SingularAttribute<Usuario, Date> fechaIngreso;
	public static volatile SingularAttribute<Usuario, String> apellido;
	public static volatile ListAttribute<Usuario, Factura> facturaList;
	public static volatile SingularAttribute<Usuario, Empresa> idEmpresa;
	public static volatile SingularAttribute<Usuario, Integer> id;
	public static volatile SingularAttribute<Usuario, String> telefono;
	public static volatile SingularAttribute<Usuario, String> contrasenha;
	public static volatile SingularAttribute<Usuario, String> email;

}

