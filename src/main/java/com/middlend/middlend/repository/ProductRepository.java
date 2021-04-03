package com.middlend.middlend.repository;

import com.middlend.middlend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {




    @Query("{'product' : ?0}")
    public Optional<Product> findProductBy (String product);
}
