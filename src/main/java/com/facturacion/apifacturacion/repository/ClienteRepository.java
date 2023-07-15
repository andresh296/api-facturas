package com.facturacion.apifacturacion.repository;

import com.facturacion.apifacturacion.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
