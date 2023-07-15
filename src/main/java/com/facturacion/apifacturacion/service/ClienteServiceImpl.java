package com.facturacion.apifacturacion.service;

import com.facturacion.apifacturacion.exception.ResourceNotFoundException;
import com.facturacion.apifacturacion.models.Cliente;
import com.facturacion.apifacturacion.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public Cliente getById(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("El cliente con id:" + id + " no se encontro"));
    }

    @Override
    public Cliente create(Cliente cliente) {
        return repository.save(cliente);
    }
}
