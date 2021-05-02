package com.sgse.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Servicios.class)
public abstract class Servicios_ {

	public static volatile SingularAttribute<Servicios, String> descripcion;
	public static volatile SingularAttribute<Servicios, Integer> id;
	public static volatile ListAttribute<Servicios, Plan> planList;
	public static volatile SingularAttribute<Servicios, String> nombre;

}

