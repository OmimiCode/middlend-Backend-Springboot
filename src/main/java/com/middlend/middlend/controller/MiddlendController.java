package com.middlend.middlend.controller;

import com.middlend.middlend.exception.MiddlendException;
import com.middlend.middlend.exception.ProductException;
import com.middlend.middlend.model.Product;
import com.middlend.middlend.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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


    @PostMapping("/product")
    public ResponseEntity<?> AddProductToInventory(@Valid @RequestBody Product product){
        try{
            product.setDateAddedToInventory( new Date(System.currentTimeMillis()));
            productRepo.save(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") String productId){
        Optional<Product> productOptional = productRepo.findById(productId);
        if(productOptional.isPresent()){
            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("product with " + productId +" is not found", HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable("id") String productId, @RequestBody Product product){
        Optional<Product> productOptional = productRepo.findById(productId);
        if(productOptional.isPresent()){
            Product productToSave = productOptional.get();
            productToSave.setDateLastModified( new Date(System.currentTimeMillis()));
            productToSave.setPrice(productToSave.getPrice()!= null? product.getPrice(): productToSave.getPrice());
            productToSave.setDescription(productToSave.getDescription() != null? product.getDescription(): productToSave.getDescription());
            productToSave.setName(productToSave.getName() != null ? product.getName() : productToSave.getName());
            return new ResponseEntity<>(productToSave, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("product with " + productId +" is not found", HttpStatus.NOT_FOUND);
        }
    }




    @DeleteMapping("/product/{id}")
    public  ResponseEntity<?> removeProductById(@PathVariable("id") String productId){
        try{
            Optional<Product> productOptional = productRepo.findById(productId);
            if(productOptional.isPresent()){
                productRepo.deleteById(productId);
                return new ResponseEntity<>("product with " + productId +" is suceesfully deleted ", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("product with " + productId +" is not found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


}
