package com.germanheinz.microservices.servicesitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "services-products")
@EnableFeignClients
@SpringBootApplication
public class ServicesItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesItemsApplication.class, args);
	}

}
