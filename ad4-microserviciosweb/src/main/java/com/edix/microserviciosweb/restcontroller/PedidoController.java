package com.edix.microserviciosweb.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.microserviciosweb.modelo.beans.Pedido;
import com.edix.microserviciosweb.modelo.services.IntPedidoServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private IntPedidoServices pservices;
	
	@GetMapping("/{id}")
	public List<Pedido> verPorComercial(@PathVariable ("id") int idComercial) {
		try {
            return this.pservices.pedidosDeComercial( idComercial );
        } catch ( Exception e ){
            e.printStackTrace();
            return null;
        }
	}
	
	/*
	@GetMapping( "/{id}" )
    public List<Pedido> pedidos( @PathVariable( "id" ) int idComercial ) {
        return this.pservices.pedidosDeComercial( idComercial );
    }
    */

}
