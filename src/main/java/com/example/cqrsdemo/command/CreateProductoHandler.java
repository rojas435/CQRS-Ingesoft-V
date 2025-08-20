package com.example.cqrsdemo.command;

import com.example.cqrsdemo.model.Producto;
import com.example.cqrsdemo.repository.ProductoRepository;

public class CreateProductoHandler {
    private final ProductoRepository repository;

    public CreateProductoHandler(ProductoRepository repository) {
        this.repository = repository;
    }

    public void handle(CreateProductoCommand command) {
        Producto producto = new Producto(command.getId(), command.getNombre(), command.getPrecio());
        repository.save(producto);
    }
}
