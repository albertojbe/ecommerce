package com.albertojbe.simpleecommerce.models.dtos.sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SaleRequest {

    private List<ProductQuantity> productQuantityList = new ArrayList<>();


}
