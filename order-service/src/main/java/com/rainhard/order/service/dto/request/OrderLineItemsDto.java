package com.rainhard.order.service.dto.request;


import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OrderLineItemsDto {

    private Long id;
    private String skuCode;
    private int price;
    private int quantity;

}

