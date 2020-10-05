package com.germanheinz.microservices.servicesitems.controller;

import com.germanheinz.microservices.servicesitems.models.Item;
import com.germanheinz.microservices.servicesitems.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/findAllItems")
    public List<Item> getAllItems(){
        return itemService.findAll();
    }

    @GetMapping("/detail/{id}/quantity/{quantity}")
    public Item getDetail(@PathVariable Long id, @PathVariable Integer quantity){
        return  itemService.findById(id, quantity);
    }

}
