package com.facturacion.apifacturacion.service;

import com.facturacion.apifacturacion.models.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> getAll();

    public Cliente getById(Long id);

    public Cliente create(Cliente cliente);
}
