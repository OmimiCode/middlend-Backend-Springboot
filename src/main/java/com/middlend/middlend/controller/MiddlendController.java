package com.middlend.middlend.controller;

import com.middlend.middlend.model.Product;
import com.middlend.middlend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MiddlendController {

    @Autowired
    private ProductRepository productRepo;

    @GetMapping("/product")
    public ResponseEntity<?> getAllProducts(){
        List<Product> productList = productRepo.findAll();
        if(productList.size() > 0){
            return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("No products available", HttpStatus.NOT_FOUND);
        }
    }

}
