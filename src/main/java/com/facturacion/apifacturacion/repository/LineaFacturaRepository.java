package com.facturacion.apifacturacion.repository;

import com.facturacion.apifacturacion.models.LineaFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineaFacturaRepository extends JpaRepository<LineaFactura, Long> {
}
