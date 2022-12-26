package com.rainhard.product.service.controller;

import com.rainhard.product.service.dto.request.ProductRequestDto;
import com.rainhard.product.service.dto.response.ProductResponseDto;
import com.rainhard.product.service.model.Product;
import com.rainhard.product.service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDto productRequest){
        var product = productService.saveProduct(Product.from(productRequest));
        return new ResponseEntity<>("Product saved", HttpStatus.CREATED);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findAllProduct(){
        var products = productService.getAllProduct();
        if(products.isEmpty()){
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        List<ProductResponseDto> productResponses = new ArrayList<>();
        for(Product product : products){
            productResponses.add(ProductResponseDto.from(product));
        }
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }
}
