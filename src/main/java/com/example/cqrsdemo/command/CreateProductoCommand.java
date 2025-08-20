package com.example.cqrsdemo.command;

public class CreateProductoCommand {
    private String id;
    private String nombre;
    private double precio;

    public CreateProductoCommand(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
