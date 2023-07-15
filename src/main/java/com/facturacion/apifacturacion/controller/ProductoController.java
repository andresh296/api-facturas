package com.facturacion.apifacturacion.controller;

import com.facturacion.apifacturacion.dto.ProductoRequest;
import com.facturacion.apifacturacion.models.Producto;
import com.facturacion.apifacturacion.service.ProductoService;
import com.facturacion.apifacturacion.web.ResponseOk;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public ResponseEntity<ResponseOk> getAll() {
        return ResponseOk.createResponse(HttpStatus.OK, "Lista de productos", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk> getById(@PathVariable Long id) {
        return ResponseOk.createResponse(HttpStatus.OK, "Producto con id:" + id, service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseOk> create(@RequestBody @Valid ProductoRequest productoRequest) {
        Producto producto = productoRequest.toDomainModel();

        return ResponseOk.createResponse(HttpStatus.CREATED, "producto creado", service.create(producto));
    }
}
