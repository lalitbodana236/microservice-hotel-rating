package com.fakecoders.foundation.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomConfig {
	
	@Bean
	//@Primary
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/*@LoadBalanced
	@Bean
	RestTemplate loadBalanced() {
		return new RestTemplate();
	}*/

}
