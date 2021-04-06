package com.middlend.middlend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection= "middlend")
public class Order {
    @Id
    private String orderId;
    private Map<String, Item> orderItems;
    private BigDecimal orderTotal;
    private LocalDate delivery;
    private LocalDate deliveryDate;
    private LocalDate orderDate;
    private boolean isPaid;
//    private Address deliveryAddress;

}
