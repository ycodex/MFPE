package com.processPensionMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Client;

@SpringBootApplication
@EnableFeignClients
public class ProcessPensionMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProcessPensionMicroserviceApplication.class, args);
	}
	@Bean
	public Client feignClient() {
	    return new Client.Default(null, null);
	}

}
