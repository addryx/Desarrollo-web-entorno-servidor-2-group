package com.edix.microserviciosweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.microserviciosweb.modelo.beans.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
