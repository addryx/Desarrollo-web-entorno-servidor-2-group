package com.edix.microserviciosweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.microserviciosweb.modelo.beans.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
