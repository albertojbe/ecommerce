package com.albertojbe.simpleecommerce.controllers;

import com.albertojbe.simpleecommerce.models.dtos.sale.SaleRequest;
import com.albertojbe.simpleecommerce.models.dtos.sale.SaleResponse;
import com.albertojbe.simpleecommerce.services.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {

    SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/buy")
    public ResponseEntity<SaleResponse> buy(@RequestBody SaleRequest saleRequest) {
        return ResponseEntity.ok(saleService.buy(saleRequest));
    }
}
