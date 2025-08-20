package com.example.cqrsdemo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.cqrsdemo.model.Producto;

public class ProductoRepository {
    private final Map<String, Producto> productos = new HashMap<>();

    public void save(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    public Producto findById(String id) {
        return productos.get(id);
    }

    public List<Producto> findAll() {
        return new ArrayList<>(productos.values());
    }

    public void deleteById(String id) {
        productos.remove(id);
    }
}
