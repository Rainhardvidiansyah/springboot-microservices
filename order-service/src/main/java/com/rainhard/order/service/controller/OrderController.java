package com.rainhard.order.service.controller;

import com.rainhard.order.service.dto.request.OrderRequestDto;
import com.rainhard.order.service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDto orderRequest){
        orderService.makeOrder(orderRequest);
        return new ResponseEntity<>("Successfully create order", HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> get(){
        return new ResponseEntity<>("OUT OF SERVICE", HttpStatus.NOT_FOUND);
    }


}
