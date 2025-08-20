package com.example.cqrsdemo.command;

import com.example.cqrsdemo.repository.ProductoRepository;

public class DeleteProductoHandler {
    private final ProductoRepository repository;

    public DeleteProductoHandler(ProductoRepository repository) {
        this.repository = repository;
    }

    public boolean handle(DeleteProductoCommand command) {
        if (repository.findById(command.getId()) != null) {
            repository.deleteById(command.getId());
            return true;
        }
        return false;
    }
}
