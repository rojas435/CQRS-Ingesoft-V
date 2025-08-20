package com.example.cqrsdemo.command;

public class DeleteProductoCommand {
    private String id;

    public DeleteProductoCommand(String id) {
        this.id = id;
    }

    public String getId() { return id; }
}
