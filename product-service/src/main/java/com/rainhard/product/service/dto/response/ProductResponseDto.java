package com.rainhard.product.service.dto.response;


import com.rainhard.product.service.model.Product;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @ToString
public class ProductResponseDto {

    private Long productId;
    private String productName;
    private String description;
    private int price;

    public static ProductResponseDto from(Product product){
        return new ProductResponseDto(product.getId(), product.getName(),
                product.getDescription(),
                product.getPrice());
    }
}
