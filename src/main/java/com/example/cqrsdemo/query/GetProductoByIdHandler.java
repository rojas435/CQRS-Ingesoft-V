package com.example.cqrsdemo.query;

import com.example.cqrsdemo.model.ProductoReadModel;
import com.example.cqrsdemo.repository.ProductoReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductoByIdHandler {
    private final ProductoReadRepository readRepository;

    @Autowired
    public GetProductoByIdHandler(ProductoReadRepository readRepository) {
        this.readRepository = readRepository;
    }

    public Optional<ProductoReadModel> handle(GetProductoByIdQuery query) {
        return readRepository.findById(query.getId());
    }
}
