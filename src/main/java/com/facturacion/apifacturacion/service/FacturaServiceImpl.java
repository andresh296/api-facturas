package com.facturacion.apifacturacion.service;

import com.facturacion.apifacturacion.exception.ResourceNotFoundException;
import com.facturacion.apifacturacion.models.Cliente;
import com.facturacion.apifacturacion.models.Factura;
import com.facturacion.apifacturacion.models.LineaFactura;
import com.facturacion.apifacturacion.models.Producto;
import com.facturacion.apifacturacion.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository repository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @Override
    public List<Factura> getAll() {
        return repository.findAll();
    }

    @Override
    public Factura getById(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("La factura con id:" + id + " no se encontro"));
    }

    @Override
    public Factura create(Factura factura) {
        Factura facturaDB = new Factura();
        facturaDB = repository.save(facturaDB);

        Cliente cliente = clienteService.getById(factura.getCliente().getId());
        facturaDB.setCliente(cliente);

        facturaDB.setFecha(factura.getFecha());

        List<LineaFactura> lineas = factura.getLineas();

        lineas.forEach(linea -> {
            Producto producto = productoService.getById(linea.getProducto().getId());
            linea.setProducto(producto);
            linea.setTotal(linea.getCantidad() * linea.getProducto().getPrecio());
        });

        facturaDB.setLineas(lineas);

        facturaDB.reviewTotal();

        facturaDB = repository.save(facturaDB);
        return facturaDB;
    }
}
