package com.albertojbe.simpleecommerce.models.dtos;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {

    private String name;
    private String description;
    private float price;
    private int quantity;
}
