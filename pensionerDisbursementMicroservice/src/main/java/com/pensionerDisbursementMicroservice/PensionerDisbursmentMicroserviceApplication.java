package com.pensionerDisbursementMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import feign.Client;

@SpringBootApplication
@EnableFeignClients
public class PensionerDisbursmentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerDisbursmentMicroserviceApplication.class, args);
	}
	@Bean
	public Client feignClient() {
	    return new Client.Default(null, null);
	}

}
