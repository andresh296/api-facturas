package com.facturacion.apifacturacion.service;

import com.facturacion.apifacturacion.models.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> getAll();

    public Producto getById(Long id);

    public Producto create(Producto producto);
}
