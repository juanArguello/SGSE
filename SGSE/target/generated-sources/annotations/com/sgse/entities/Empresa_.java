package com.sgse.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empresa.class)
public abstract class Empresa_ {

	public static volatile SingularAttribute<Empresa, String> ruc;
	public static volatile SingularAttribute<Empresa, String> rubro;
	public static volatile ListAttribute<Empresa, Sucursal> sucursalList;
	public static volatile ListAttribute<Empresa, Usuario> usuarioList;
	public static volatile SingularAttribute<Empresa, Integer> id;
	public static volatile SingularAttribute<Empresa, String> nombreMarca;
	public static volatile SingularAttribute<Empresa, String> nombreEmpresa;
	public static volatile SingularAttribute<Empresa, String> email;

}

