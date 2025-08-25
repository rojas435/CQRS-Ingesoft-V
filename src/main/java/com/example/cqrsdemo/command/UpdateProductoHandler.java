package com.example.cqrsdemo.command;

import com.example.cqrsdemo.model.Producto;
import com.example.cqrsdemo.model.ProductoReadModel;
import com.example.cqrsdemo.repository.ProductoRepository;
import com.example.cqrsdemo.repository.ProductoReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateProductoHandler {
    private final ProductoRepository writeRepository;
    private final ProductoReadRepository readRepository;

    @Autowired
    public UpdateProductoHandler(ProductoRepository writeRepository, ProductoReadRepository readRepository) {
        this.writeRepository = writeRepository;
        this.readRepository = readRepository;
    }

    @Transactional
    public boolean handle(UpdateProductoCommand command) {
        // 1. Actualizar en la base de datos de escritura (SQL Server)
        Optional<Producto> productoOpt = writeRepository.findById(command.getId());
        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            producto.setNombre(command.getNombre());
            producto.setPrecio(command.getPrecio());
            writeRepository.save(producto);
            
            // 2. Sincronizar con la base de datos de lectura (MongoDB)
            ProductoReadModel readModel = new ProductoReadModel(producto);
            readRepository.save(readModel);
            return true;
        }
        return false;
    }
}
