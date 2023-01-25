package com.edix.microserviciosweb.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.microserviciosweb.modelo.beans.Comercial;
import com.edix.microserviciosweb.modelo.services.IntComercialServices;

import ch.qos.logback.core.model.Model;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comercial")
public class ComercialController {

	@Autowired
	private IntComercialServices comservices;
	
	@PostMapping("/alta")
	public String darAltaComercial (Comercial comercial) {
		return (comservices.altaComercial(comercial) == 1)?"Alta realizada correctamente":"¡ERROR! Alta no realizada.";
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String darBajaComercial(Comercial comercial, @PathVariable("id") int idComercial) {
		return (comservices.eliminarComercial(idComercial) == 1)?"Comercial eliminado correctamente":"¡ERROR! No se ha podido eliminar.";
	}
	
	@GetMapping("/uno/{id}")
	public String visualizarComercial(Model model, Comercial comercial, @PathVariable("id") int idComercial) {
		return comservices.verComercial(null);
	}
	
}
