<<<<<<< HEAD
package com.pensionerDisbursementMicroservice.client;

import java.io.IOException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pensionerDisbursementMicroservice.Exception.NotFoundException;
import com.pensionerDisbursementMicroservice.Model.PensionerDetail;

@FeignClient(name = "PensionerDetailsService",url="${details.path}")
public interface PensionDetailsClient {
	@PostMapping("/pensionerDetailByAadhaar/{aadhaarNumber}")
	public PensionerDetail getPensionerDetailByAadhaar(@PathVariable long aadhaarNumber)
			throws IOException, NotFoundException;
=======
package com.pensionerDisbursementMicroservice.client;

import java.io.IOException;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pensionerDisbursementMicroservice.Exception.NotFoundException;
import com.pensionerDisbursementMicroservice.Model.PensionerDetail;


/**
 * 
 * Gets the pensioner detail by Aadhaar number
 * 
 * @param aadhaarNumber
 * @return
 * 
 *
 */



@FeignClient("PensionerDetailsService")//, url = "http://localhost:8082/"
public interface PensionDetailsClient {
	@PostMapping("/pensionerDetailByAadhaar/{aadhaarNumber}")
	public PensionerDetail getPensionerDetailByAadhaar(@PathVariable long aadhaarNumber)
			throws IOException, NotFoundException;
>>>>>>> 36d564dbfe4a3946ee3935933a0ed6a2cb99255d
}