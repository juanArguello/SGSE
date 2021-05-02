package com.sgse.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Compra.class)
public abstract class Compra_ {

	public static volatile SingularAttribute<Compra, Seguro> seguro;
	public static volatile SingularAttribute<Compra, Date> fecha;
	public static volatile SingularAttribute<Compra, Cliente> cliente;
	public static volatile SingularAttribute<Compra, Integer> monto;
	public static volatile SingularAttribute<Compra, CompraPK> compraPK;

}

