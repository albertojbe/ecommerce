package com.albertojbe.simpleecommerce.services;

import com.albertojbe.simpleecommerce.exceptions.ResourceNotFoundException;
import com.albertojbe.simpleecommerce.models.Product;
import com.albertojbe.simpleecommerce.models.dtos.ProductRequest;
import com.albertojbe.simpleecommerce.repositories.ProductRepository;
import com.albertojbe.simpleecommerce.utils.DozerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public Product deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.delete(product);
        return product;
    }

    public Product createProduct(ProductRequest productRequest) {
        Product entity = DozerMapper.parseObject(productRequest, Product.class);
        System.out.println(entity);
        System.out.println(productRequest);
        entity.setActive(entity.enableActive());
        return productRepository.save(entity);
    }

    public Product updateProduct(Long id, ProductRequest productRequest) {
        Product entity = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        entity.setName(productRequest.getName());
        entity.setDescription(productRequest.getDescription());
        entity.setPrice(productRequest.getPrice());
        entity.setQuantity(productRequest.getQuantity());
        entity.setActive(entity.enableActive());
        return productRepository.save(entity);
    }

    public void updateProduct(Product product) {
        product.setActive(product.enableActive());
        productRepository.save(product);
    }

}
