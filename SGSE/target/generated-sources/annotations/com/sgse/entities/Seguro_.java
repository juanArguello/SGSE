package com.sgse.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Seguro.class)
public abstract class Seguro_ {

	public static volatile SingularAttribute<Seguro, String> descripcion;
	public static volatile SingularAttribute<Seguro, Integer> precio;
	public static volatile SingularAttribute<Seguro, String> tipoServicio;
	public static volatile SingularAttribute<Seguro, Integer> iva;
	public static volatile SingularAttribute<Seguro, String> paqueteServicio;
	public static volatile SingularAttribute<Seguro, Integer> id;
	public static volatile ListAttribute<Seguro, Plan> planList;
	public static volatile ListAttribute<Seguro, Compra> compraList;
	public static volatile ListAttribute<Seguro, RegistrarVenta> registrarVentaList;

}

