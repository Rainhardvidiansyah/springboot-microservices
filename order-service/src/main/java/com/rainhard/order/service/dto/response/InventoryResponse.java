package com.rainhard.order.service.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryResponse {

    private String skuCode;
    private boolean isInStock;


}
