package com.example.cqrsdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cqrsdemo.command.CreateProductoCommand;
import com.example.cqrsdemo.command.CreateProductoHandler;
import com.example.cqrsdemo.command.DeleteProductoCommand;
import com.example.cqrsdemo.command.DeleteProductoHandler;
import com.example.cqrsdemo.command.UpdateProductoCommand;
import com.example.cqrsdemo.command.UpdateProductoHandler;
import com.example.cqrsdemo.model.Producto;
import com.example.cqrsdemo.query.GetAllProductosHandler;
import com.example.cqrsdemo.query.GetAllProductosQuery;
import com.example.cqrsdemo.query.GetProductoByIdHandler;
import com.example.cqrsdemo.query.GetProductoByIdQuery;
import com.example.cqrsdemo.repository.ProductoRepository;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoRepository repository = new ProductoRepository();
    private final CreateProductoHandler createHandler = new CreateProductoHandler(repository);
    private final GetProductoByIdHandler getByIdHandler = new GetProductoByIdHandler(repository);
    private final GetAllProductosHandler getAllHandler = new GetAllProductosHandler(repository);
    private final UpdateProductoHandler updateHandler = new UpdateProductoHandler(repository);
    private final DeleteProductoHandler deleteHandler = new DeleteProductoHandler(repository);

    @PostMapping
    public void crearProducto(@RequestBody CreateProductoCommand command) {
        createHandler.handle(command);
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable String id) {
        return getByIdHandler.handle(new GetProductoByIdQuery(id));
    }

    @GetMapping
    public List<Producto> obtenerTodos() {
        return getAllHandler.handle(new GetAllProductosQuery());
    }

    @PutMapping("/{id}")
    public boolean actualizarProducto(@PathVariable String id, @RequestBody UpdateProductoCommand command) {
        // Asegura que el id de la URL se use
        UpdateProductoCommand cmd = new UpdateProductoCommand(id, command.getNombre(), command.getPrecio());
        return updateHandler.handle(cmd);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarProducto(@PathVariable String id) {
        return deleteHandler.handle(new DeleteProductoCommand(id));
    }
}
