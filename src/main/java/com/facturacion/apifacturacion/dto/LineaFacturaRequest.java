package com.facturacion.apifacturacion.dto;

import com.facturacion.apifacturacion.models.LineaFactura;
import com.facturacion.apifacturacion.models.Producto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LineaFacturaRequest {

    @JsonProperty("producto_id")
    private Long productoId;

    private int cantidad;

    public LineaFactura toDomainModel(){
        Producto producto = new Producto();
        producto.setId(this.productoId);

        return new LineaFactura(
                producto,
                this.cantidad
        );
    }
}
