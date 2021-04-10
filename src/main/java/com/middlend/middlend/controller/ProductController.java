package com.middlend.middlend.controller;

import com.middlend.middlend.exception.ProductException;
import com.middlend.middlend.model.Product;
import com.middlend.middlend.repository.ProductRepository;


import com.middlend.middlend.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ProductServices productServices;

    @GetMapping("/product")
    public ResponseEntity<?> getAllProducts(){
        List<Product> productList = productServices.getAllProducts();
       return new ResponseEntity<>(productList, productList.size()>0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


    @PostMapping("/product")
    public ResponseEntity<?> AddProductToInventory(@Valid @RequestBody Product product){
        try{
            productServices.addProduct(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (ConstraintViolationException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }catch (ProductException exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.CONFLICT);
        }
    }



    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable("productId") String productId){
        try{
            return new ResponseEntity<>(productServices.findProductById(productId), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable("id") String productId, @RequestBody Product product){
    try{
        productServices.updateProduct(productId,product);
        return new ResponseEntity<>("Updated product with "+ productId, HttpStatus.OK);
    }catch (ConstraintViolationException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }catch (ProductException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
    }


    @DeleteMapping("/product/{id}")
    public  ResponseEntity<?> removeProductById(@PathVariable("id") String productId){
        try{
            productServices.removeProduct(productId);
                return new ResponseEntity<>("product with " + productId +" is suceesfully deleted ", HttpStatus.OK);
        }catch (ProductException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


}
