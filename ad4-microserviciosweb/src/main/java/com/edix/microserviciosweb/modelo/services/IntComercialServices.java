package com.edix.microserviciosweb.modelo.services;

import java.util.List;

import com.edix.microserviciosweb.modelo.beans.Comercial;

public interface IntComercialServices {

	List<Comercial> findAll();
	Comercial findById(int idComercial);
	int altaComercial(Comercial comercial);
	int eliminarComercial(int idComercial);
	String verComercial(Comercial comercial);

}
