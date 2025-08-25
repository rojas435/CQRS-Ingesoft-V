package com.example.cqrsdemo.command;

import com.example.cqrsdemo.repository.ProductoRepository;
import com.example.cqrsdemo.repository.ProductoReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteProductoHandler {
    private final ProductoRepository writeRepository;
    private final ProductoReadRepository readRepository;

    @Autowired
    public DeleteProductoHandler(ProductoRepository writeRepository, ProductoReadRepository readRepository) {
        this.writeRepository = writeRepository;
        this.readRepository = readRepository;
    }

    @Transactional
    public boolean handle(DeleteProductoCommand command) {
        // 1. Verificar y eliminar de la base de datos de escritura (SQL Server)
        if (writeRepository.existsById(command.getId())) {
            writeRepository.deleteById(command.getId());
            
            // 2. Sincronizar eliminación con la base de datos de lectura (MongoDB)
            readRepository.deleteById(command.getId());
            return true;
        }
        return false;
    }
}
