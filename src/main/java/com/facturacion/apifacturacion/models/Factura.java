package com.facturacion.apifacturacion.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"factura"})
    private List<LineaFactura> lineas;

    private double total;

    public Factura(LocalDateTime fecha, Cliente cliente, List<LineaFactura> lineas) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.lineas = lineas;
    }

    public void reviewTotal() {
        this.total = 0;
        for (int i = 0; i < this.lineas.size(); i++) {
            this.total += this.lineas.get(i).getTotal();
        }
    }
}
