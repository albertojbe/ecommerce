package com.albertojbe.simpleecommerce.services;

import com.albertojbe.simpleecommerce.exceptions.ResourceNotFoundException;
import com.albertojbe.simpleecommerce.models.dtos.sale.ProductQuantity;
import com.albertojbe.simpleecommerce.models.dtos.sale.ProductQuantityValue;
import com.albertojbe.simpleecommerce.models.dtos.sale.SaleRequest;
import com.albertojbe.simpleecommerce.models.dtos.sale.SaleResponse;
import com.albertojbe.simpleecommerce.repositories.ProductRepository;
import com.albertojbe.simpleecommerce.repositories.SaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    SaleRepository saleRepository;
    ProductRepository productRepository;

    public SaleService(SaleRepository saleRepository, ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    public SaleResponse buy(SaleRequest saleRequest) {

        List<ProductQuantityValue> quantityValues = new ArrayList<>();
        float totalValue = 0;

        for (ProductQuantity productQuantity : saleRequest.getProductQuantityList()) {
            var product = productRepository.findById(productQuantity.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            System.out.println(product);
            ProductQuantityValue productQuantityValue = new ProductQuantityValue();
            if (productQuantity.getQuantity() < product.getQuantity()) {
                float value = productQuantity.getQuantity() * product.getPrice();
                productQuantityValue.setQuantity(productQuantity.getQuantity());
                productQuantityValue.setValue(value);
                productQuantityValue.setNameProduct(product.getName());
                quantityValues.add(productQuantityValue);
                totalValue += value;
            }
        }
        return new SaleResponse(quantityValues, totalValue, LocalDateTime.now());

    }
}
