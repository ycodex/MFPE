package com.pensionerDetailsMicroservice.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensionerDetailsMicroservice.Exception.NotFoundException;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PensionerdetailService {

	@Autowired
	csvToBean bean;

	private Map<Long, PensionerDetail> pensionDetails;
	
	/**
	 * returns PensionerDetailByAadhaarNumber
	 * 
	 * @param aadhaarNumber
	 * @return
	 * @throws IOException
	 * @throws NotFoundException
	 * @throws NumberFormatException
	 * @throws ParseException
	 */

	public PensionerDetail getPensionerDetailByAadhaarNumber(long aadhaarNumber)
			throws IOException, NotFoundException, NumberFormatException, ParseException {

		pensionDetails = new HashMap<>();
		log.info("csvToBean class is being called");

		List<PensionerDetail> data = bean.getData();

		log.info("received the details from CsvToBean class");
		for (PensionerDetail pensionerDetail : data) {
			long aadharNo = pensionerDetail.getAadharNo();
			pensionDetails.put(aadharNo, pensionerDetail);
		}

		log.info("Checking for aadhaar number in pensionerDetails[map]");
		if (pensionDetails.containsKey(aadhaarNumber)) {
			return pensionDetails.get(aadhaarNumber);
		}

		else {
			log.error("Aadhaar Number Not Found");
			throw new NotFoundException("AadharNumber Not Found");
		}

	}

}
