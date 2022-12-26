package com.rainhard.inventory.service.service;

import com.rainhard.inventory.service.dto.response.InventoryResponseDto;
import com.rainhard.inventory.service.model.Inventory;
import com.rainhard.inventory.service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponseDto> isInStock(List<String> skuCode){
        return inventoryRepository.findInventoryBySkuCodeIn(skuCode)
                .stream()
                .map(inventory -> {
                    var inventoryResponse = new InventoryResponseDto();
                    inventoryResponse.setSkuCode(inventory.getSkuCode());
                    inventoryResponse.setInStock(inventory.getQuantity() > 0);
                    return inventoryResponse;
                })
                .collect(Collectors.toList());
    }
}
