package com.germanheinz.microservices.servicesitems.services;

import com.germanheinz.microservices.servicesitems.models.Item;
import com.germanheinz.microservices.servicesitems.models.Product;

import java.util.List;

public interface ItemService {

    List<Item> findAll();

    Item findById(Long id, Integer quantity);

    Product save(Product product);

    Product update(Product product, Long id);

    void delete(Long id);
}
