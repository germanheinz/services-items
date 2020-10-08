package com.germanheinz.microservices.servicesitems.controller;

import com.germanheinz.microservices.servicesitems.models.Item;
import com.germanheinz.microservices.servicesitems.models.Product;
import com.germanheinz.microservices.servicesitems.services.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ItemController {

    @Qualifier("servicesFeign")
    @Autowired
    private ItemService itemService;

    @GetMapping("/findAllItems")
    public List<Item> getAllItems(){
        return itemService.findAll();
    }

    @HystrixCommand(fallbackMethod = "alternativeMethod")
    @GetMapping("/detail/{id}/quantity/{quantity}")
    public Item getDetail(@PathVariable Long id, @PathVariable Integer quantity){
        return  itemService.findById(id, quantity);
    }


    public Item alternativeMethod(Long id, Integer quantity, Throwable hystrixCommand){
        Product pro = new Product();
        pro.setName("test");
        pro.setCreatedDate(new Date());
        pro.setId(id);
        pro.setPrice(1.0);

        return new Item(pro, quantity);
    }

}
