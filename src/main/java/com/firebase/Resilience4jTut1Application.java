package com.firebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Resilience4jTut1Application {

	public static void main(String[] args) {
		SpringApplication.run(Resilience4jTut1Application.class, args);
	}
	
	@Bean
	RestTemplate getTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
