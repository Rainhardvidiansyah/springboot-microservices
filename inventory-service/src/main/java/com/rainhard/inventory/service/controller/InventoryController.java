package com.rainhard.inventory.service.controller;

import com.rainhard.inventory.service.dto.response.InventoryResponseDto;
import com.rainhard.inventory.service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/")
    public String get(){
        return "This is inventory service";
    }

    @GetMapping("/code")
    @ResponseBody
    public ResponseEntity<?> isInStock(@RequestParam List<String> skuCode){
        var inventory = inventoryService.isInStock(skuCode);
        if(inventory.isEmpty()){
            return new ResponseEntity<>("Inventory not found", HttpStatus.NOT_FOUND);
        }
        log.info("Is in stock method get hit...");
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }
}
