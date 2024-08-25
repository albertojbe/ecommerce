package com.albertojbe.simpleecommerce.models.dtos.sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponse {

    List<Purchased> purchasedList;
    private float totalValue;
    LocalDateTime saleDate;

}
