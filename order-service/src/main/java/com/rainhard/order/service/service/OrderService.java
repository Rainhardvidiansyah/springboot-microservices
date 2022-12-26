package com.rainhard.order.service.service;

import com.rainhard.order.service.dto.request.OrderLineItemsDto;
import com.rainhard.order.service.dto.request.OrderRequestDto;
import com.rainhard.order.service.dto.response.InventoryResponse;
import com.rainhard.order.service.model.Order;
import com.rainhard.order.service.model.OrderLineItems;
import com.rainhard.order.service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public void makeOrder(OrderRequestDto orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItems().stream()
                .map(this::mapToObject).collect(Collectors.toList());
        order.setOrderLineItems(orderLineItems);

        List<String> skuCodes = order.getOrderLineItems()
                .stream().map(OrderLineItems::getSkuCode).collect(Collectors.toList());


        //web client to get product inventory
        InventoryResponse[] inventoryResponses =
                webClientBuilder.build().get()
                .uri("http://inventory-service/api/v1/inventory/code",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProduct = Arrays.stream(inventoryResponses)
                .allMatch(InventoryResponse::isInStock);


        if(allProduct){
            orderRepository.save(order);
        }else{
            throw new IllegalStateException("Product is not in stock...");
        }

    }

    private OrderLineItems mapToObject(OrderLineItemsDto orderLineItemsDto) {
        var orderLineItems = new OrderLineItems();
        orderLineItems.setId(orderLineItemsDto.getId());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }
}
