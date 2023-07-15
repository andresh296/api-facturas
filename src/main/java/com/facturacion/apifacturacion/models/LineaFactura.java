package com.facturacion.apifacturacion.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "linea_facturas")
public class LineaFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Producto producto;

    private int cantidad;

    @ManyToOne
    private Factura factura;

    private double total;

    public LineaFactura(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
