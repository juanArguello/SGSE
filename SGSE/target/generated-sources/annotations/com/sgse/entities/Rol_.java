package com.sgse.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rol.class)
public abstract class Rol_ {

	public static volatile SingularAttribute<Rol, String> descripcion;
	public static volatile ListAttribute<Rol, Permisos> permisosList;
	public static volatile SingularAttribute<Rol, Integer> id;
	public static volatile SingularAttribute<Rol, String> nombre;

}

