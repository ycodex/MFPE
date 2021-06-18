package com.pensionerDetailsMicroservice.Service;

import java.io.IOException;
import java.text.ParseException;

import com.pensionerDetailsMicroservice.Exception.NotFoundException;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;

public interface PensionerDetailService {

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
			throws IOException, NotFoundException, NumberFormatException, ParseException;

}
