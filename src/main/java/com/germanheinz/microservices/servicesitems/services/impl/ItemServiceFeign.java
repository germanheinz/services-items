package com.germanheinz.microservices.servicesitems.services.impl;

import com.germanheinz.microservices.servicesitems.clients.ProductClientsRest;
import com.germanheinz.microservices.servicesitems.models.Item;
import com.germanheinz.microservices.servicesitems.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {

    @Autowired
    ProductClientsRest productClientsRestFeign;

    @Override
    public List<Item> findAll() {
        return productClientsRestFeign.findAll().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        return new Item(productClientsRestFeign.findById(id), quantity);
    }
}
