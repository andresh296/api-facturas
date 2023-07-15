package com.facturacion.apifacturacion.repository;

import com.facturacion.apifacturacion.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
