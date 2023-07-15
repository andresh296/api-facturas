package com.facturacion.apifacturacion.service;

import com.facturacion.apifacturacion.models.Cliente;
import com.facturacion.apifacturacion.models.Factura;

import java.util.List;

public interface FacturaService {

    public List<Factura> getAll();

    public Factura getById(Long id);

    public Factura create(Factura factura);
}
