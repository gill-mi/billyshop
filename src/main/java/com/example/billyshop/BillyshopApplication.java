package com.example.billyshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
public class BillyshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillyshopApplication.class, args);
	}

}
