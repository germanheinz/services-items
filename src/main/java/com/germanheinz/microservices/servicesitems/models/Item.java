package com.germanheinz.microservices.servicesitems.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

    private Product product;
    private Integer quantity;


}
