package com.processPensionMicroservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.processPensionMicroservice.client.PensionDisbursementClient;
import com.processPensionMicroservice.client.PensionerDetailClient;
import com.processPensionMicroservice.exception.NotFoundException;
import com.processPensionMicroservice.model.PensionDetail;
import com.processPensionMicroservice.model.PensionerDetail;
import com.processPensionMicroservice.model.PensionerInput;
import com.processPensionMicroservice.model.ProcessPensionInput;
import com.processPensionMicroservice.model.ProcessPensionResponse;
import com.processPensionMicroservice.service.ProcessPensionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class processPensionController {

	@Autowired
	PensionerDetailClient pensionerDetailClient;
	@Autowired
	PensionDisbursementClient pensionDisbursementClient;
	@Autowired
	ProcessPensionService processPensionService;

	/**
	 * The POST endpoint should calculate the PensionInput, invoke the Pensioner
	 * detail microservice and get the salary detail and Pension amount calculation
	 * 
	 * @param pensionerInput
	 * @return
	 */
	@PostMapping("/pensionerInput")
	public PensionDetail getPensionDetails(@RequestBody PensionerInput pensionerInput) {

		log.info(pensionerInput.toString());

		// Gets the details from the aadhar number from pension detail ms
		PensionerDetail pensionerDetail = pensionerDetailClient
				.getPensionerDetailByAadhaar(pensionerInput.getAadharNumber());


		PensionDetail pensionDetail = null;

		if (pensionerDetail == null) {
			return pensionDetail;
		}

		// checks the input and database details
		ProcessPensionResponse ppr = processPensionService.checkdetails(pensionerInput, pensionerDetail);

		if (ppr.getPensionStatusCode() == 10) {
			// Calculates the pension
			pensionDetail = processPensionService.getresult(pensionerDetail);

			ProcessPensionInput processPensionInput = new ProcessPensionInput(pensionerInput.getAadharNumber(),
					pensionDetail.getPensionAmount(), 500);

			log.info(processPensionInput.toString());

			// Calculate pension amount
			try {
				ppr = this.getcode(processPensionInput);
				if (ppr.getPensionStatusCode() == 21) {
					pensionDetail.setPensionAmount(pensionDetail.getPensionAmount() - 550);
				} else if (ppr.getPensionStatusCode() == 10) {
					pensionDetail.setPensionAmount(pensionDetail.getPensionAmount() - 500);
				}
			} catch (IOException | NotFoundException e) {
				return null;
			}
		}
		// Pension Details
		log.info(pensionDetail.toString());
		return pensionDetail;
	}

	/**
	 * Gets the code from pension disbursement microservice
	 * 
	 * @param processPensionInput
	 * @return
	 * @throws IOException
	 * @throws NotFoundException
	 */
	@PostMapping("/ProcessPension")
	public ProcessPensionResponse getcode(@RequestBody ProcessPensionInput processPensionInput)
			throws IOException, NotFoundException {
		return pensionDisbursementClient.getcode(processPensionInput);
	}

}
