package com.middlend.middlend.service;
import com.middlend.middlend.exception.ProductException;
import com.middlend.middlend.model.Product;
import java.util.List;


public interface ProductServices {
   Product findProductById(String productId) throws ProductException;
   void addProduct(Product product) throws  ProductException;
   void removeProduct(String productId) throws ProductException;
   void updateProduct(String productId, Product product )throws ProductException;
   List<Product> getAllProducts();
}
