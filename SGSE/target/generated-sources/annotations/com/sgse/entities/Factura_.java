package com.sgse.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Factura.class)
public abstract class Factura_ {

	public static volatile SingularAttribute<Factura, String> descripcion;
	public static volatile SingularAttribute<Factura, Integer> nroFactura;
	public static volatile SingularAttribute<Factura, Integer> precioUnitario;
	public static volatile SingularAttribute<Factura, String> rucCiCliente;
	public static volatile SingularAttribute<Factura, Usuario> idUsuario;
	public static volatile SingularAttribute<Factura, String> direccion;
	public static volatile SingularAttribute<Factura, Integer> costoTotal;
	public static volatile SingularAttribute<Factura, Integer> numeracion;
	public static volatile SingularAttribute<Factura, Date> fechaLimieValidez;
	public static volatile SingularAttribute<Factura, Integer> valorIva;
	public static volatile SingularAttribute<Factura, String> nombreCliente;
	public static volatile SingularAttribute<Factura, Date> fechaFactura;
	public static volatile SingularAttribute<Factura, String> tipoPago;
	public static volatile SingularAttribute<Factura, Integer> liquidacionIva;
	public static volatile SingularAttribute<Factura, Integer> id;
	public static volatile SingularAttribute<Factura, Integer> cantidad;
	public static volatile SingularAttribute<Factura, String> telefono;
	public static volatile SingularAttribute<Factura, Inventario> idInventario;
	public static volatile SingularAttribute<Factura, String> nombreEmisor;
	public static volatile SingularAttribute<Factura, Integer> nroTimbrado;

}

