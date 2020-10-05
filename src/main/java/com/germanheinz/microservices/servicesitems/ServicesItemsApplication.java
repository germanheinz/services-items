package com.germanheinz.microservices.servicesitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServicesItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesItemsApplication.class, args);
	}

}
