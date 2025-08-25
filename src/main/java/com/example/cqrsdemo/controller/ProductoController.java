package com.example.cqrsdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.example.cqrsdemo.model.ProductoReadModel;
import com.example.cqrsdemo.query.GetAllProductosHandler;
import com.example.cqrsdemo.query.GetAllProductosQuery;
import com.example.cqrsdemo.query.GetProductoByIdHandler;
import com.example.cqrsdemo.query.GetProductoByIdQuery;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final CreateProductoHandler createHandler;
    private final GetProductoByIdHandler getByIdHandler;
    private final GetAllProductosHandler getAllHandler;
    private final UpdateProductoHandler updateHandler;
    private final DeleteProductoHandler deleteHandler;

    @Autowired
    public ProductoController(
            CreateProductoHandler createHandler,
            GetProductoByIdHandler getByIdHandler,
            GetAllProductosHandler getAllHandler,
            UpdateProductoHandler updateHandler,
            DeleteProductoHandler deleteHandler) {
        this.createHandler = createHandler;
        this.getByIdHandler = getByIdHandler;
        this.getAllHandler = getAllHandler;
        this.updateHandler = updateHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping
    public ResponseEntity<String> crearProducto(@RequestBody CreateProductoCommand command) {
        createHandler.handle(command);
        return ResponseEntity.ok("Producto creado exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoReadModel> obtenerProducto(@PathVariable String id) {
        Optional<ProductoReadModel> producto = getByIdHandler.handle(new GetProductoByIdQuery(id));
        return producto.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ProductoReadModel> obtenerTodos() {
        return getAllHandler.handle(new GetAllProductosQuery());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable String id, @RequestBody UpdateProductoCommand command) {
        UpdateProductoCommand cmd = new UpdateProductoCommand(id, command.getNombre(), command.getPrecio());
        boolean actualizado = updateHandler.handle(cmd);
        if (actualizado) {
            return ResponseEntity.ok("Producto actualizado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable String id) {
        boolean eliminado = deleteHandler.handle(new DeleteProductoCommand(id));
        if (eliminado) {
            return ResponseEntity.ok("Producto eliminado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
