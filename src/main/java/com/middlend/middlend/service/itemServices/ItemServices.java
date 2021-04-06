package com.middlend.middlend.service.itemServices;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface ItemServices {
    public void addItems(int quantity);


    public void reduceItems(int newQuantity);

}
