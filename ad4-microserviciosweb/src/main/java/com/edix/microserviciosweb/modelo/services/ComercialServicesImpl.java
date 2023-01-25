package com.edix.microserviciosweb.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.microserviciosweb.modelo.beans.Comercial;
import com.edix.microserviciosweb.repository.ComercialRepository;

@Service
public class ComercialServicesImpl implements IntComercialServices {

	@Autowired
	private ComercialRepository crepo;

	@Override
	public List<Comercial> findAll() {
		return crepo.findAll();
	}

	@Override
	public Comercial findById(int idComercial) {
		return crepo.findById(idComercial).orElse(null);
	}

	@Override
	public int altaComercial(Comercial comercial) {
		if (!crepo.existsById(comercial.getIdComercial())) {
			crepo.save(comercial);
			return 1;
		}
		return 0;
	}

	@Override
	public int eliminarComercial(int idComercial) {
		int filas = 0;
		try {
			crepo.deleteById(idComercial);
			filas = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Comercial verComercial(Comercial comercial) {
		return comercial;
	}

	@Override
	public List<Comercial> listaComercialesCliente(int idCliente) {
		
		try {
            return this.crepo.listaComercialesCliente(idCliente);
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
	}
	
	@Override
    public List<Comercial> comercialesConPedidos() {

        try {
            return this.crepo.comercialesConPedidos();
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }
	
}



