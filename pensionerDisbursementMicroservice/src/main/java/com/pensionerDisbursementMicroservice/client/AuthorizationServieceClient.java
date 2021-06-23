package com.pensionerDisbursementMicroservice.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authorization-service", url="${auth.path}") 
public interface AuthorizationServieceClient {
	
	@PostMapping("/validate")
	public Boolean validateToken(@RequestBody String token);
}
