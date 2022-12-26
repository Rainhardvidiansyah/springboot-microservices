package com.rainhard.product.service.service;

import com.rainhard.product.service.model.Product;
import com.rainhard.product.service.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void saveProduct() {
        var product = new Product();
        Mockito.when(productRepository.save(Mockito.any(Product.class)))
                .thenReturn(product);
        var service = productService.saveProduct(product);
        Mockito.verify(productRepository, Mockito.times(1)).save(product);
        Assertions.assertNotNull(service);
    }

    @Test
    void getAllProduct() {
        List<Product> products = new ArrayList<>();
        Mockito.when(productRepository.findAll()).thenReturn(List.of());
        var service = productService.getAllProduct();
        Mockito.verify(productRepository, Mockito.times(1)).findAll();
        Assertions.assertNotNull(service);
    }
}