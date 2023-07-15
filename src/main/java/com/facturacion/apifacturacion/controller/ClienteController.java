package com.facturacion.apifacturacion.controller;

import com.facturacion.apifacturacion.dto.ClienteRequest;
import com.facturacion.apifacturacion.models.Cliente;
import com.facturacion.apifacturacion.service.ClienteService;
import com.facturacion.apifacturacion.service.ProductoService;
import com.facturacion.apifacturacion.web.ResponseOk;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<ResponseOk> getAll() {
        return ResponseOk.createResponse(HttpStatus.OK, "Lista de clientes", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk> getById(@PathVariable Long id) {
        return ResponseOk.createResponse(HttpStatus.OK, "Cliente con id:" + id, service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseOk> create(@RequestBody @Valid ClienteRequest clienteRequest){
        Cliente cliente = clienteRequest.toDomainModel();

        return ResponseOk.createResponse(HttpStatus.CREATED, "cliente creado", service.create(cliente));
    }
}
