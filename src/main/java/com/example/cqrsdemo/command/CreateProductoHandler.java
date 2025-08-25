package com.example.cqrsdemo.command;

import com.example.cqrsdemo.model.Producto;
import com.example.cqrsdemo.model.ProductoReadModel;
import com.example.cqrsdemo.repository.ProductoRepository;
import com.example.cqrsdemo.repository.ProductoReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateProductoHandler {
    private final ProductoRepository writeRepository;
    private final ProductoReadRepository readRepository;

    @Autowired
    public CreateProductoHandler(ProductoRepository writeRepository, ProductoReadRepository readRepository) {
        this.writeRepository = writeRepository;
        this.readRepository = readRepository;
    }

    @Transactional
    public void handle(CreateProductoCommand command) {
        // 1. Guardar en la base de datos de escritura (SQL Server)
        Producto producto = new Producto(command.getId(), command.getNombre(), command.getPrecio());
        writeRepository.save(producto);
        
        // 2. Sincronizar con la base de datos de lectura (MongoDB)
        ProductoReadModel readModel = new ProductoReadModel(producto);
        readRepository.save(readModel);
    }
}
