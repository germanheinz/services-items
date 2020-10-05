package com.germanheinz.microservices.servicesitems.clients;

import com.germanheinz.microservices.servicesitems.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "services-products")
public interface ProductClientsRest {

    @GetMapping("/findAll")
    public List<Product> findAll();

    @GetMapping("/find/{id}")
    public Product findById(@PathVariable Long id);
}
