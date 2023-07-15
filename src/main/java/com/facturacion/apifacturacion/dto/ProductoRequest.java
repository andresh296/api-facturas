package com.facturacion.apifacturacion.dto;


import com.facturacion.apifacturacion.models.Producto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductoRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    private double precio;

    public Producto toDomainModel() {
        return new Producto(
                this.nombre,
                this.descripcion,
                this.precio
        );
    }
}
