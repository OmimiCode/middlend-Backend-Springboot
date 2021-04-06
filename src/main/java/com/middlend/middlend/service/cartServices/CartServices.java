package com.middlend.middlend.service.cartServices;

import com.middlend.middlend.exception.ProductException;
import com.middlend.middlend.model.Item;
import com.middlend.middlend.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

@Service
public interface CartServices {
    public  void addToCart(Product product) throws ProductException;
    public  void addToCart(Product product,int quantity);
    public boolean verifiedProduct(Product product);
    public boolean removeFromCart(Product product);
    public Collection<Item> getCartItems();
    public BigDecimal calculateCartTotal();
    public BigDecimal getTotal() ;

}
