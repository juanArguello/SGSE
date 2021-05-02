package com.sgse.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, Salon> idSalon;
	public static volatile SingularAttribute<Cliente, String> ruc;
	public static volatile SingularAttribute<Cliente, Integer> cedula;
	public static volatile SingularAttribute<Cliente, String> apellido;
	public static volatile SingularAttribute<Cliente, String> direccion;
	public static volatile SingularAttribute<Cliente, Integer> estadoCuenta;
	public static volatile SingularAttribute<Cliente, Integer> id;
	public static volatile SingularAttribute<Cliente, String> telefono;
	public static volatile ListAttribute<Cliente, Compra> compraList;
	public static volatile SingularAttribute<Cliente, String> nombre;
	public static volatile SingularAttribute<Cliente, String> email;

}

