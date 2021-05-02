package com.sgse.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContratoVenta.class)
public abstract class ContratoVenta_ {

	public static volatile SingularAttribute<ContratoVenta, Date> fecha;
	public static volatile SingularAttribute<ContratoVenta, String> tipoServicio;
	public static volatile SingularAttribute<ContratoVenta, String> nombreCliente;
	public static volatile SingularAttribute<ContratoVenta, Integer> costo;
	public static volatile SingularAttribute<ContratoVenta, Integer> cedula;
	public static volatile SingularAttribute<ContratoVenta, Usuario> idUsuario;
	public static volatile SingularAttribute<ContratoVenta, Integer> tipoPago;
	public static volatile SingularAttribute<ContratoVenta, Integer> id;
	public static volatile SingularAttribute<ContratoVenta, String> paqueteSeguro;
	public static volatile SingularAttribute<ContratoVenta, String> modoPago;
	public static volatile SingularAttribute<ContratoVenta, String> observacion;

}

