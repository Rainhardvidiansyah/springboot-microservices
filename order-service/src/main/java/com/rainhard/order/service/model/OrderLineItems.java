package com.rainhard.order.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_line_items")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "sku_code")
    private String skuCode;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;
}
