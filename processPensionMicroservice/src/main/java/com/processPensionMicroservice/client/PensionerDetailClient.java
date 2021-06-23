package com.processPensionMicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.processPensionMicroservice.model.PensionerDetail;

@FeignClient(name = "PensionerDetailsService", url="${details.path}")
public interface PensionerDetailClient {
	@PostMapping("/pensionerDetailByAadhaar/{aadhaarNumber}")
	public PensionerDetail getPensionerDetailByAadhaar(@PathVariable long aadhaarNumber);
}