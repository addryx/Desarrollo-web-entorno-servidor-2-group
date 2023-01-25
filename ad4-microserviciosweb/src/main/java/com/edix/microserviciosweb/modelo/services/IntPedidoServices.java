package com.edix.microserviciosweb.modelo.services;

import java.util.List;

import com.edix.microserviciosweb.modelo.beans.Pedido;

public interface IntPedidoServices {

	List<Pedido> findAll();
	Pedido findById(int idPedido);
	public List<Pedido> findByComercial(int idComercial);
	List<Pedido> pedidosDeComercial(int idComercial);
	
}
