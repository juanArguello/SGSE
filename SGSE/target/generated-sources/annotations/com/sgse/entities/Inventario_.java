package com.sgse.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Inventario.class)
public abstract class Inventario_ {

	public static volatile SingularAttribute<Inventario, String> descripcion;
	public static volatile SingularAttribute<Inventario, Date> fecha;
	public static volatile SingularAttribute<Inventario, String> tipoServicio;
	public static volatile SingularAttribute<Inventario, Integer> costo;
	public static volatile SingularAttribute<Inventario, String> comprobante;
	public static volatile ListAttribute<Inventario, Factura> facturaList;
	public static volatile SingularAttribute<Inventario, Float> id;
	public static volatile SingularAttribute<Inventario, Integer> cantidad;
	public static volatile ListAttribute<Inventario, Reporte> reporteList;

}

