package com.middlend.middlend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection= "middlend")
public class Product {
    @Id
    private String productId;

    private String name;

    private String description;

    private BigDecimal price;
    private Date DateAddedToInventory;
    private Date DateLastModified;

}
