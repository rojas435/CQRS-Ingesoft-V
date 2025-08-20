package com.example.cqrsdemo.query;

import com.example.cqrsdemo.model.Producto;
import com.example.cqrsdemo.repository.ProductoRepository;

public class GetProductoByIdHandler {
    private final ProductoRepository repository;

    public GetProductoByIdHandler(ProductoRepository repository) {
        this.repository = repository;
    }

    public Producto handle(GetProductoByIdQuery query) {
        return repository.findById(query.getId());
    }
}
