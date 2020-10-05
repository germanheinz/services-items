package com.germanheinz.microservices.servicesitems.services;

import com.germanheinz.microservices.servicesitems.models.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();

    Item findById(Long id, Integer quantity);
}
