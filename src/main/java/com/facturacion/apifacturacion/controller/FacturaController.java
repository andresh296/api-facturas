package com.facturacion.apifacturacion.controller;

import com.facturacion.apifacturacion.dto.FacturaRequest;
import com.facturacion.apifacturacion.models.Factura;
import com.facturacion.apifacturacion.repository.FacturaRepository;
import com.facturacion.apifacturacion.service.FacturaService;
import com.facturacion.apifacturacion.service.ProductoService;
import com.facturacion.apifacturacion.web.ResponseOk;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("facturas")
public class FacturaController {

    @Autowired
    private FacturaService service;

    @GetMapping
    public ResponseEntity<ResponseOk> getAll() {
        return ResponseOk.createResponse(HttpStatus.OK, "Lista de facturas", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk> getById(@PathVariable Long id) {
        return ResponseOk.createResponse(HttpStatus.OK, "Factura con id:" + id, service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseOk> create(@RequestBody @Valid FacturaRequest facturaRequest) {
        Factura factura = facturaRequest.toDomainModel();
        return ResponseOk.createResponse(HttpStatus.CREATED, "factura creada", service.create(factura));
    }
}
