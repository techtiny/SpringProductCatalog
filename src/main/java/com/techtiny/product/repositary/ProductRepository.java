package com.techtiny.product.repositary;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techtiny.product.model.Product;

public interface ProductRepository extends MongoRepository<Product,String>{

}
