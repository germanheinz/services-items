package com.germanheinz.microservices.servicesitems.services.impl;

import com.germanheinz.microservices.servicesitems.models.Item;
import com.germanheinz.microservices.servicesitems.models.Product;
import com.germanheinz.microservices.servicesitems.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("servicesRestTemplate")
public class ItemServicesImpl implements ItemService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(restTemplate.getForObject("http://services-products/findAll", Product[].class));

        //Convert Product object to Item Object
        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());

        Product product = restTemplate.getForObject("http://services-products/find/{id}", Product.class, pathVariables);
        return new Item(product, quantity);
    }

    @Override
    public Product save(Product product) {
        HttpEntity<Product> body =  new HttpEntity<Product>(product);
        ResponseEntity<Product> response = restTemplate.exchange("http://services-products/save", HttpMethod.POST, body, Product.class);
        return response.getBody();
    }

    @Override
    public Product update(Product product, Long id) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        HttpEntity<Product> body =  new HttpEntity<Product>(product);
        ResponseEntity<Product> response = restTemplate.exchange("http://services-products/edit/{id}", HttpMethod.PUT, body, Product.class, pathVariables);
        return response.getBody();
    }

    @Override
    public void delete(Long id) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        restTemplate.delete("http://services-products/delete/{id}", pathVariables);
    }
}
