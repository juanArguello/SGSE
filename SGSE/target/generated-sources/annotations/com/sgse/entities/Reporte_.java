package com.sgse.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reporte.class)
public abstract class Reporte_ {

	public static volatile SingularAttribute<Reporte, String> descripcion;
	public static volatile SingularAttribute<Reporte, String> tipoSeguro;
	public static volatile SingularAttribute<Reporte, String> tipoServicio;
	public static volatile ListAttribute<Reporte, Inventario> inventarioList;
	public static volatile SingularAttribute<Reporte, Float> id;
	public static volatile SingularAttribute<Reporte, String> observacion;

}

