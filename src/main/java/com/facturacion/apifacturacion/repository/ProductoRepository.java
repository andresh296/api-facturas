package com.facturacion.apifacturacion.repository;

import com.facturacion.apifacturacion.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
