package com.example.cqrsdemo.command;

import com.example.cqrsdemo.model.Producto;
import com.example.cqrsdemo.repository.ProductoRepository;

public class UpdateProductoHandler {
    private final ProductoRepository repository;

    public UpdateProductoHandler(ProductoRepository repository) {
        this.repository = repository;
    }

    public boolean handle(UpdateProductoCommand command) {
        Producto producto = repository.findById(command.getId());
        if (producto != null) {
            producto.setNombre(command.getNombre());
            producto.setPrecio(command.getPrecio());
            repository.save(producto);
            return true;
        }
        return false;
    }
}
