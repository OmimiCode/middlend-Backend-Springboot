package com.middlend.middlend.service.productServices;

import com.middlend.middlend.exception.ProductException;
import com.middlend.middlend.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServices {
   public Product findProductById(String productId) throws ProductException;
   public void addProduct(Product product) throws  ProductException;
   public void removeProduct(String productId) throws ProductException;
   public void updateProduct(String productId, Product product )throws ProductException;
   public List<Product> getAllProducts();
}
