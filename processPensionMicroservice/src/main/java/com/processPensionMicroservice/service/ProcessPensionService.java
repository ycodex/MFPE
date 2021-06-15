package com.processPensionMicroservice.service;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.processPensionMicroservice.model.PensionDetail;
import com.processPensionMicroservice.model.PensionerDetail;
import com.processPensionMicroservice.model.PensionerInput;
import com.processPensionMicroservice.model.ProcessPensionResponse;

@Service
public class ProcessPensionService {
	
	
	@Value("${self.pension}")
	private float selfPension;
	@Value("${family.pension}")
	private float familyPension;
	
	
	/**
	 * Calculates the pension based on the SELF and FAMILY
	 * 
	 * @param pd
	 * @return
	 */
	public PensionDetail getresult(PensionerDetail pd) {
		double d = 0;
		PensionDetail p;
		if (pd.getPensionType().equalsIgnoreCase("self")) {
			d = (pd.getSalary() * selfPension + pd.getAllowance());
			d= Math.round(d*100.0)/100.0;
		}
		else if (pd.getPensionType().equalsIgnoreCase("family")) {
			d = (pd.getSalary() * familyPension + pd.getAllowance());
			d= Math.round(d*100.0)/100.0;
		}
		p = new PensionDetail(pd.getName(), pd.getDateOfBirth(), pd.getPan(), pd.getPensionType(), d);
		return p;

	}

	/**
	 * Check the details of the given input and the details from database(from
	 * pension details microservice)
	 * 
	 * @param pi
	 * @param pd
	 * @return
	 */
	public ProcessPensionResponse checkdetails(PensionerInput pi, PensionerDetail pd) {
		ProcessPensionResponse ppr = new ProcessPensionResponse();

		if (pi.getName().equalsIgnoreCase(pd.getName())
				&& (pi.getDateOfBirth().getDay() == pd.getDateOfBirth().getDay()
						&& pi.getDateOfBirth().getMonth() == pd.getDateOfBirth().getMonth()
						&& pi.getDateOfBirth().getYear() == pd.getDateOfBirth().getYear())
				&& pi.getPan().equalsIgnoreCase(pd.getPan())
				&& pi.getPensionType().equalsIgnoreCase(pd.getPensionType())) {
			ppr.setPensionStatusCode(10);
		} else {
			ppr.setPensionStatusCode(21);
		}
		return ppr;
	}
}
