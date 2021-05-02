package com.sgse.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sucursal.class)
public abstract class Sucursal_ {

	public static volatile SingularAttribute<Sucursal, String> estado;
	public static volatile SingularAttribute<Sucursal, String> direccion;
	public static volatile SingularAttribute<Sucursal, String> localidad;
	public static volatile SingularAttribute<Sucursal, Empresa> idEmpresa;
	public static volatile SingularAttribute<Sucursal, Integer> id;
	public static volatile SingularAttribute<Sucursal, String> telefono;

}

