package com.rainhard.inventory.service.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventory_id")
    private Long id;

    @Column(name = "sku_code")
    private String skuCode;

    @Column(name = "quantity_inventory")
    private int quantity;
}
