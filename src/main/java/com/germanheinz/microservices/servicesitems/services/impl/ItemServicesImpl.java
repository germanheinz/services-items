package com.germanheinz.microservices.servicesitems.services.impl;

import com.germanheinz.microservices.servicesitems.models.Item;
import com.germanheinz.microservices.servicesitems.models.Product;
import com.germanheinz.microservices.servicesitems.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServicesImpl  implements ItemService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(restTemplate.getForObject("http://localhost:8001/findAll", Product[].class));

        //Convert Product object to Item Object
        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());

        Product product = restTemplate.getForObject("http://localhost:8001/find/{id}", Product.class, pathVariables);
        return new Item(product, quantity);
    }
}
