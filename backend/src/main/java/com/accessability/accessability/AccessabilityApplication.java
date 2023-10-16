package com.accessability.accessability;

import com.accessability.accessability.services.DataInitializationService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessabilityApplication
{
	@Autowired
	private DataInitializationService dataInitializationService;

	public static void main(String[] args) {
		SpringApplication.run(AccessabilityApplication.class, args);
		System.out.println("Welcome to AccessAbility App");
	}

	@PostConstruct
	public void init()
	{
		dataInitializationService.initializeData();
	}
}
