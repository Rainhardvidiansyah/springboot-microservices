package com.rainhard.inventory.service.dto.response;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class InventoryResponseDto {

    private String skuCode;
    private boolean isInStock;
}
