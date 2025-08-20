package com.example.cqrsdemo.query;

import java.util.List;

import com.example.cqrsdemo.model.Producto;
import com.example.cqrsdemo.repository.ProductoRepository;

public class GetAllProductosHandler {
    private final ProductoRepository repository;

    public GetAllProductosHandler(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> handle(GetAllProductosQuery query) {
        return repository.findAll();
    }
}
