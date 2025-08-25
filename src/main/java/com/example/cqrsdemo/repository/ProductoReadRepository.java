package com.example.cqrsdemo.repository;

import com.example.cqrsdemo.model.ProductoReadModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoReadRepository extends MongoRepository<ProductoReadModel, String> {

}
