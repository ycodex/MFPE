package com.pensionerDetailsMicroservice.Controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pensionerDetailsMicroservice.Exception.NotFoundException;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;
import com.pensionerDetailsMicroservice.Service.PensionerDetailService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author rohithKuppa
 *
 */

@RestController
@Slf4j
public class PensionerDetailsController {

	@Autowired
	private PensionerDetailService pds;

	/**
	 * gets pensioner detail by aadhaar
	 * 
	 * @param aadhaarNumber
	 * @return
	 */
	@PostMapping("/pensionerDetailByAadhaar/{aadhaarNumber}")
	public PensionerDetail getPensionerDetailByAadhaar(@PathVariable long aadhaarNumber) {
		log.info("/pensionerDetailByAadhaar/{aadhaarNumber} is being hit/accessed");
		try {
			return pds.getPensionerDetailByAadhaarNumber(aadhaarNumber);
		} catch (NumberFormatException | IOException | NotFoundException | ParseException e) {
			log.error("Pensioner Details not found");
			return null;
		}

	}
}
