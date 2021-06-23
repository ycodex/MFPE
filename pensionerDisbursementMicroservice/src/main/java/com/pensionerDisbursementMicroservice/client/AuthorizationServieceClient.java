<<<<<<< HEAD
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
=======
package com.pensionerDisbursementMicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 * 
 * Validating using token
 *
 */


@FeignClient("authorization-service") //url = "http://localhost:9696/"
public interface AuthorizationServieceClient {
	
	@PostMapping("/validate")
	public Boolean validateToken(@RequestBody String token);
}
>>>>>>> 36d564dbfe4a3946ee3935933a0ed6a2cb99255d
