package com.hats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HatsApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(HatsApplication.class, args);
	}

}
