package com.accessability.accessability;

import com.accessability.accessability.services.DataInitializationService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessabilityApplication
{
	@Autowired
	private DataInitializationService dataInitializationService;

	@Value("${init.method.enabled}")
	private boolean initMethodEnabled;

	public static void main(String[] args) {
		SpringApplication.run(AccessabilityApplication.class, args);
		System.out.println("Welcome to AccessAbility App");
	}

	@PostConstruct
	public void init()
	{
		if (initMethodEnabled)
			dataInitializationService.initializeData();
	}
}
