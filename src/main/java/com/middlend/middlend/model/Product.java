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
    @NotBlank(message = "cant be blank")
    @NotEmpty(message = "cant be empty")
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty(message = "cant be empty")
    private String description;

    @NotNull
    @NotBlank
    @NotEmpty(message = "cant be empty")
    private BigDecimal price;

    private Date DateAddedToInventory;
    private Date DateLastModified;

}
