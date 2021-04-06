package com.middlend.middlend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection= "middlend")
public class Item {
    private Product product;
    private int quantity;
    private BigDecimal total;


    public void addItems(int quantity){
        this.quantity += quantity;
        this.total = this.product.getPrice().multiply(BigDecimal.valueOf(this.quantity));
    }

    public void reduceItems(int newQuantity){
        if (quantity > newQuantity){
            quantity = newQuantity;
            this.total = this.product.getPrice().multiply(BigDecimal.valueOf(this.quantity));
        }
    }
}
