package com.edix.microserviciosweb.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.microserviciosweb.modelo.beans.Comercial;
import com.edix.microserviciosweb.modelo.services.IntComercialServices;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/comercial")
public class ComercialController {

	@Autowired
	private IntComercialServices comservices;
	
	@GetMapping("/uno/{id}")
	public String verComercial(Model model, Comercial comercial, @PathVariable("id") int idComercial) {
		return comservices.verComercial(null);
	}
	
}
