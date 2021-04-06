package com.middlend.middlend.service.productServices;

import com.middlend.middlend.exception.ProductException;
import com.middlend.middlend.model.Product;
import com.middlend.middlend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.ConstraintViolationException;
import java.util.*;


public class ProductServiceImpl implements ProductServices {

    @Autowired
    private ProductRepository productRepo;


    @Override
    public Product findProductById(String productId) throws ProductException {
        Optional<Product> productOptional = productRepo.findById(productId);
        if (productOptional.isEmpty()){
            throw new ProductException(ProductException.NotFoundException(productId));
        }else{
            return productOptional.get();
        }
    }

    @Override
    public void addProduct(Product product) throws ConstraintViolationException, ProductException {
        Optional<Product> productOptional = productRepo.findByProduct(product.getName());
        if(productOptional.isPresent()){
            throw new ProductException(ProductException.productAlreadyExist());
        }else {
            product.setDateAddedToInventory(new Date(System.currentTimeMillis()));
            productRepo.save(product);
        }
    }

    @Override
    public void removeProduct(String productId) throws ProductException {
        Optional<Product> productOptional = productRepo.findById(productId);
        if(productOptional.isPresent()){
            productRepo.deleteById(productId);
        }else{
          throw new ProductException(ProductException.NotFoundException(productId)) ;
    }
        }

    @Override
    public void updateProduct(String productId, Product product) throws ProductException {
        Optional<Product> productOptionalWithId = productRepo.findById(productId);
        Optional<Product> productWithSameName  = productRepo.findByProduct(product.getName());
        if ( productOptionalWithId.isPresent() ) {

            if(productWithSameName.isPresent()&& productWithSameName.get().getProductId().equals(productId)){
                throw new ProductException(ProductException.productAlreadyExist());
            }
            Product productToSave = productOptionalWithId.get();
            productToSave.setDateLastModified(new Date(System.currentTimeMillis()));
            productToSave.setPrice(product.getPrice());
            productToSave.setDescription(product.getDescription());
            productToSave.setName(product.getName());
            productRepo.save(productToSave);
        } else {
            throw new ProductException(ProductException.NotFoundException(productId));
        }
    }

    @Override
    public Collection<Product> getAllProducts() {
        Collection<Product> products = productRepo.findAll();
        if(products.size()>0){
            return products;
        }else{
            return new ArrayList<>();
        }

    }
}
