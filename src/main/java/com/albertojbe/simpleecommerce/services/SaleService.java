package com.albertojbe.simpleecommerce.services;

import com.albertojbe.simpleecommerce.exceptions.NoProductsPurchased;
import com.albertojbe.simpleecommerce.models.dtos.sale.ProductQuantity;
import com.albertojbe.simpleecommerce.models.dtos.sale.Purchased;
import com.albertojbe.simpleecommerce.models.dtos.sale.SaleRequest;
import com.albertojbe.simpleecommerce.models.dtos.sale.SaleResponse;
import com.albertojbe.simpleecommerce.repositories.SaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    SaleRepository saleRepository;
    ProductService productService;

    public SaleService(SaleRepository saleRepository, ProductService productService) {
        this.saleRepository = saleRepository;
        this.productService = productService;
    }

    @Transactional
    public SaleResponse buy(SaleRequest saleRequest) {

        List<Purchased> purchasedList = new ArrayList<>();
        float totalValue = 0;

        for (ProductQuantity productQuantity : saleRequest.getProductQuantityList()) {
            var product = productService.getProductById(productQuantity.getProductId());
            System.out.println(product);
            Purchased purchased = new Purchased();
            if (productQuantity.getQuantity() <= product.getQuantity()) {
                float value = productQuantity.getQuantity() * product.getPrice();
                purchased.setNameProduct(product.getName());
                purchased.setQuantity(productQuantity.getQuantity());
                purchased.setValue(value);
                purchasedList.add(purchased);
                totalValue += value;
                product.setQuantity(product.getQuantity() - productQuantity.getQuantity());
                productService.updateProduct(product);
            }
        }
        if (!purchasedList.isEmpty()) {
            return new SaleResponse(purchasedList, totalValue, LocalDateTime.now());
        }
        throw new NoProductsPurchased("No products purchased");

    }
}
