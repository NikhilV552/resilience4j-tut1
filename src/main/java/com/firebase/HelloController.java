package com.firebase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class HelloController {
	
	Logger log=LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/hello/{num}")
	@Retry(name="sample",fallbackMethod="errorMethod")
	//@CircuitBreaker(name="sample",fallbackMethod="errorMethod")
	//@Bulkhead(name="sample")
	//@RateLimiter(name="sample")
	public String sayHello(@PathVariable int num) {
		log.info("THE HELLO CONTROLLER EXECUTED FOR UNKNOWN HOST");
		int a=2/num;
		restTemplate.getForObject("http://localhost:8090/not-exist", String.class);
		return "HELLO WORKING";
	}
	
	public String errorMethod(Exception e) {
		return e.getLocalizedMessage();
	}
	
}
