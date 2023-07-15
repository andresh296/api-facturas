package com.facturacion.apifacturacion.dto;

import com.facturacion.apifacturacion.models.Cliente;
import com.facturacion.apifacturacion.models.Factura;
import com.facturacion.apifacturacion.models.LineaFactura;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class FacturaRequest {

    @JsonProperty("cliente_id")
    private Long clienteId;

    private List<LineaFacturaRequest> lineas;

    public Factura toDomainModel() {
        Cliente cliente = new Cliente();
        cliente.setId(this.clienteId);

        List<LineaFactura> lineasDomain = new ArrayList<>();
        this.lineas.forEach(l -> {
            lineasDomain.add(l.toDomainModel());
        });

        return new Factura(
                LocalDateTime.now(),
                cliente,
                lineasDomain
        );
    }
}
