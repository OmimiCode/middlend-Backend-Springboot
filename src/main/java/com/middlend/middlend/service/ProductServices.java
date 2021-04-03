package com.middlend.middlend.service;

import com.middlend.middlend.exception.ProductException;
import com.middlend.middlend.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductServices {

   public Product findProductById(String productId) throws ProductException;
   public boolean addProduct(Product product) throws  ProductException;
   public boolean removeProduct(Product product) throws ProductException;
   public Map<String,Product> getAllProducts();
}
