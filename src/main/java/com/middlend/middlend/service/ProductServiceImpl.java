package com.middlend.middlend.service;

import com.middlend.middlend.exception.ProductException;
import com.middlend.middlend.model.Product;

import java.util.Map;

public class ProductServiceImpl implements ProductServices {
    @Override
    public Product findProductById(String productId) throws ProductException {
        return null;
    }

    @Override
    public boolean addProduct(Product product) throws ProductException {
        return false;
    }

    @Override
    public boolean removeProduct(Product product) throws ProductException {
        return false;
    }

    @Override
    public Map<String, Product> getAllProducts() {
        return null;
    }
}
