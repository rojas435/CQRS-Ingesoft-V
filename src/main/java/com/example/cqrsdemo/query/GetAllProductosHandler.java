package com.example.cqrsdemo.query;

import java.util.List;

import com.example.cqrsdemo.model.ProductoReadModel;
import com.example.cqrsdemo.repository.ProductoReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllProductosHandler {
    private final ProductoReadRepository readRepository;

    @Autowired
    public GetAllProductosHandler(ProductoReadRepository readRepository) {
        this.readRepository = readRepository;
    }

    public List<ProductoReadModel> handle(GetAllProductosQuery query) {
        return readRepository.findAll();
    }
}
