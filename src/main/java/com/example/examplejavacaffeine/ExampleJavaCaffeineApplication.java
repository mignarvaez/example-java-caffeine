package com.example.examplejavacaffeine;

import com.example.examplejavacaffeine.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ExampleJavaCaffeineApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ExampleJavaCaffeineApplication.class);

	final CustomerService customerService;

	public ExampleJavaCaffeineApplication(CustomerService customerService) {
		this.customerService = customerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ExampleJavaCaffeineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Starting caffeine cache testing");
		customerService.getCustomer("1"); //No hit , since this is the first request.
		customerService.getCustomer("2"); //No hit , since this is the first request.
		customerService.getCustomer("1"); //hit , since it is already in the cache.
		customerService.getCustomer("1"); //hit , since it is already in the cache.
		customerService.getCustomer("1"); //hit , since it is already in the cache.
		customerService.getCustomer("1"); //hit , since it is already in the cache.
	}
}
