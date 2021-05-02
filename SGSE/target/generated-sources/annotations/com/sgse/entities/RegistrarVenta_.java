package com.sgse.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RegistrarVenta.class)
public abstract class RegistrarVenta_ {

	public static volatile SingularAttribute<RegistrarVenta, Seguro> seguro;
	public static volatile SingularAttribute<RegistrarVenta, RegistrarVentaPK> registrarVentaPK;
	public static volatile SingularAttribute<RegistrarVenta, Date> fecha;
	public static volatile SingularAttribute<RegistrarVenta, Integer> monto;
	public static volatile SingularAttribute<RegistrarVenta, String> tipoVenta;
	public static volatile SingularAttribute<RegistrarVenta, Usuario> usuario;

}

