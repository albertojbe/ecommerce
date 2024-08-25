package com.albertojbe.simpleecommerce.models.dtos.sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchased {
    private String nameProduct;
    private int quantity;
    private float value;
}