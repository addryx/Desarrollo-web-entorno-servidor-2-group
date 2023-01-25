package com.edix.microserviciosweb.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.microserviciosweb.modelo.beans.Comercial;
import com.edix.microserviciosweb.repository.ComercialRepository;


 /* @service se encarga de gestionar las operaciones más importantes, conecta varios repositorios 
 * y agrupa su funcionalidad */
@Service
public class ComercialServicesImpl implements IntComercialServices {
	
	 /* La anotación @Autowired inyecta la dependencia del objeto implícitamente. */
	@Autowired
	private ComercialRepository crepo;
	
	//Con este método vamos a listar todos los comerciales existentes
	@Override
	public List<Comercial> findAll() {
		return crepo.findAll();
	}

	//Con este método hacemos una búsqueda del comercial por su idComercial
	@Override
	public Comercial findById(int idComercial) {
		return crepo.findById(idComercial).orElse(null);
	}

	//Con este método damos de alta un comercial 
	@Override
	public int altaComercial(Comercial comercial) {
		if (!crepo.existsById(comercial.getIdComercial())) {
			crepo.save(comercial);
			return 1;
		}
		return 0;
	}

	//con este método eliminamos un comercial por su idComercial
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
	
	//Con este método hacemos una búsqueda del comercial directamente introducciendo el objeto
	@Override
	public Comercial verComercial(Comercial comercial) {
		return comercial;
	}
	
	//Con este método devolvemos una lista de los comerciales que han atendido a un cliente introduciendo el idCliente
	@Override
	public List<Comercial> listaComercialesCliente(int idCliente) {
		
		try {
            return this.crepo.listaComercialesCliente(idCliente);
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
	}
	
	//Con este método devolvemos una lista de los comerciles y los pedidos gestionados por cada uno 
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



