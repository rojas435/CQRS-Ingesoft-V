package com.example.cqrsdemo.query;

public class GetProductoByIdQuery {
    private final String id;

    public GetProductoByIdQuery(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
