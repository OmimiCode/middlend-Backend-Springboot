package com.middlend.middlend.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection= "middlend")
public class Product {
    @Id
    private String productId;

    @NonNull
    private String name;

    @NotEmpty(message = "Description cnt b empty")
    private String description;
    private BigDecimal price;
    private Date DateAddedToInventory;
    private Date DateLastModified;

}
