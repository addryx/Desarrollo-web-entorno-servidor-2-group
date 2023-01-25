package com.edix.microserviciosweb.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.microserviciosweb.modelo.beans.Comercial;
import com.edix.microserviciosweb.modelo.beans.Pedido;
import com.edix.microserviciosweb.modelo.services.IntComercialServices;
import com.edix.microserviciosweb.modelo.services.IntPedidoServices;

import ch.qos.logback.core.model.Model;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comercial")
public class ComercialController {

	@Autowired
	private IntComercialServices cservices;
	
	@Autowired
	private IntPedidoServices pservices;
	
	@PostMapping("/alta")
	public String darAltaComercial (Comercial comercial) {
		return (cservices.altaComercial(comercial) == 1)?"Alta realizada correctamente":"¡ERROR! Alta no realizada.";
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String darBajaComercial(Comercial comercial, @PathVariable("id") int idComercial) {
		return (cservices.eliminarComercial(idComercial) == 1)?"Comercial eliminado correctamente":"¡ERROR! No se ha podido eliminar.";
	}
	
	@GetMapping("/uno/{id}")
	public Comercial visualizarComercial(Model model, @PathVariable("id") int idComercial) {
		return cservices.findById(idComercial);
	}
	
	@GetMapping( "/byCliente/{id}" )
    public List<Comercial> porComercial( @PathVariable( "id" ) int idCliente ) {
        return this.cservices.listaComercialesCliente(idCliente);
    }
	
	@GetMapping( "/conPedidos" )
    public List<Comercial> conPedidos() {
        return this.cservices.comercialesConPedidos();
    }
	

	
}
