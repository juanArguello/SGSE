package com.sgse.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Salon.class)
public abstract class Salon_ {

	public static volatile SingularAttribute<Salon, String> descripcion;
	public static volatile ListAttribute<Salon, Cliente> clienteList;
	public static volatile SingularAttribute<Salon, Date> fecha;
	public static volatile SingularAttribute<Salon, String> horario;
	public static volatile SingularAttribute<Salon, String> localidad;
	public static volatile SingularAttribute<Salon, Integer> id;

}

