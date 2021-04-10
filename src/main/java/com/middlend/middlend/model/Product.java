package com.middlend.middlend.model;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection= "middlend")
public class Product {
    @Id
    private String productId;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private BigDecimal price;
    private Date DateAddedToInventory;
    private Date DateLastModified;

}
