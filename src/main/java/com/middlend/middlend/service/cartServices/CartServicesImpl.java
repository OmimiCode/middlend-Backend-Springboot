package com.middlend.middlend.service.cartServices;

import com.middlend.middlend.exception.ProductException;
import com.middlend.middlend.model.Item;
import com.middlend.middlend.model.Product;
import com.middlend.middlend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;


@Service
public class CartServicesImpl implements CartServices {


    @Autowired
    private ProductRepository productRepo;


    @Override
    public void addToCart(Product product)  throws ProductException {
       Optional<Product> productOptional = productRepo.findById(product.getProductId());
        if(productOptional.isEmpty()){
            throw new ProductException(ProductException.NotFoundException(product.getProductId()));
        }else{
        }

    }

    @Override
    public void addToCart(Product product, int quantity) {
    }

    @Override
    public boolean verifiedProduct(Product product) {
        return false;
    }

    @Override
    public boolean removeFromCart(Product product) {
        return false;
    }

    @Override
    public Collection<Item> getCartItems() {
        return null;
    }

    @Override
    public BigDecimal calculateCartTotal() {
        return null;
    }

    @Override
    public BigDecimal getTotal() {
        return null;
    }
}
