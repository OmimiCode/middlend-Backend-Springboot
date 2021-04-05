package com.middlend.middlend.model;

import com.middlend.middlend.service.productServices.ProductServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Map;
//import java.util.logging.Logger;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection= "middlend")
public class Cart {
    private Map<String, Item> cartItems;
    private ProductServices productService;
    private BigDecimal total = BigDecimal.ZERO;
//    private Logger logger = Logger.getLogger(Cart.class.getName());
//    private PaymentCard paymentCard;
//    private Address deliveryAddress;
}
