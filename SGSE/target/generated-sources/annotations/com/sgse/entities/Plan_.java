package com.sgse.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Plan.class)
public abstract class Plan_ {

	public static volatile SingularAttribute<Plan, String> descripcion;
	public static volatile ListAttribute<Plan, Servicios> serviciosList;
	public static volatile SingularAttribute<Plan, Seguro> idSeguro;
	public static volatile SingularAttribute<Plan, Integer> id;
	public static volatile SingularAttribute<Plan, String> nombre;

}

