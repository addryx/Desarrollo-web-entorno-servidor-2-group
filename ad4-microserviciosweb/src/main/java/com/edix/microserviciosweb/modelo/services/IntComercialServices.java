package com.edix.microserviciosweb.modelo.services;

import java.util.List;

import com.edix.microserviciosweb.modelo.beans.Comercial;

public interface IntComercialServices {

	List<Comercial> findAll();
	Comercial findById(int idComercial);
	int altaComercial(Comercial comercial);
	int eliminarComercial(int idComercial);
	Comercial verComercial(Comercial comercial);
	List<Comercial> listaComercialesCliente(int idCliente);
	List<Comercial> comercialesConPedidos();

}
