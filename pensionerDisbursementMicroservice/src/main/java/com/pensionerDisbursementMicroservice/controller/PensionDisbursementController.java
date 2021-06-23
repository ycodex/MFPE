<<<<<<< HEAD
package com.pensionerDisbursementMicroservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pensionerDisbursementMicroservice.Exception.NotFoundException;
import com.pensionerDisbursementMicroservice.Model.ProcessPensionInput;
import com.pensionerDisbursementMicroservice.Model.ProcessPensionResponse;
import com.pensionerDisbursementMicroservice.client.PensionDetailsClient;
import com.pensionerDisbursementMicroservice.service.PensionDisbursmentServiceImpl;

@RestController
public class PensionDisbursementController {

	@Autowired
	private PensionDetailsClient pdp;

	@Autowired
	private PensionDisbursmentServiceImpl pds;

	@PostMapping("/disbursePension")
	public ProcessPensionResponse getcode(@RequestBody ProcessPensionInput processPensionInput)
			throws IOException, NotFoundException {
		ProcessPensionResponse p = pds.code(
				pdp.getPensionerDetailByAadhaar(processPensionInput.getAadharNumber()).getBank(),
				processPensionInput.getServiceCharge());
		return p;
	}

}
=======
package com.pensionerDisbursementMicroservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pensionerDisbursementMicroservice.Exception.NotFoundException;
import com.pensionerDisbursementMicroservice.Model.ProcessPensionInput;
import com.pensionerDisbursementMicroservice.Model.ProcessPensionResponse;
import com.pensionerDisbursementMicroservice.client.PensionDetailsClient;
import com.pensionerDisbursementMicroservice.service.PensionDisbursmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PensionDisbursementController {

	@Autowired
	private PensionDetailsClient pdp;
	

	@Autowired
	private PensionDisbursmentService pds;

	@PostMapping("/disbursePension")
	public ProcessPensionResponse getcode(@RequestBody ProcessPensionInput processPensionInput)
			throws IOException, NotFoundException {
		log.info("");
		log.info("Requesting the bank details ");
		ProcessPensionResponse p = pds.code(
				pdp.getPensionerDetailByAadhaar(processPensionInput.getAadharNumber()).getBank(),
				processPensionInput.getServiceCharge());
		log.info("Getting the service charge...");
		return p;
		
	}

}
>>>>>>> 36d564dbfe4a3946ee3935933a0ed6a2cb99255d
