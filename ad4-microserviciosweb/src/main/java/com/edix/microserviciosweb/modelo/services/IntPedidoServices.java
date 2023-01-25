package com.edix.microserviciosweb.modelo.services;

import java.util.List;

import com.edix.microserviciosweb.modelo.beans.Pedido;

public interface IntPedidoServices {

	//Creamos un método para listar todos los pedidos
	List<Pedido> findAll();
	
	//Creamos un método para localizar un pedido con el idPedido
	Pedido findById(int idPedido);
	
	//Creamos un método para listar los pedidos gestionados por los comerciales con el idComercial  
	public List<Pedido> findByComercial(int idComercial);
	
	//Creamos un método para listar los pedidos gestionados por los comerciales con el idComercial
	List<Pedido> pedidosDeComercial(int idComercial);
	
}
