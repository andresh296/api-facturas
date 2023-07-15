package com.facturacion.apifacturacion.service;

import com.facturacion.apifacturacion.exception.ResourceNotFoundException;
import com.facturacion.apifacturacion.models.Producto;
import com.facturacion.apifacturacion.repository.ProductoRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @Override
    public Producto getById(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("El producto con id:" + id + " no se encontro"));
    }

    @Override
    public Producto create(Producto producto) {
        return repository.save(producto);
    }
}
