package com.rainhard.order.service.dto.request;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor @ToString
public class OrderRequestDto {

    private List<OrderLineItemsDto> orderLineItems;
}
