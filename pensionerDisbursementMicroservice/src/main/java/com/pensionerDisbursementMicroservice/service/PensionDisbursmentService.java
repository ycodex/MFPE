package com.pensionerDisbursementMicroservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pensionerDisbursementMicroservice.Model.Bank;
import com.pensionerDisbursementMicroservice.Model.ProcessPensionResponse;

@Service
public class PensionDisbursmentService {
	
	@Value("${public.bankcharge}")
	private double publicBankCharge;
	@Value("${private.bankcharge}")
	private double privateBankcharge;
	
	public ProcessPensionResponse code(Bank bank, double serviceCharge) {
		ProcessPensionResponse ppr = new ProcessPensionResponse();
		double x = bank.getBankType().equalsIgnoreCase("public") ? publicBankCharge : privateBankcharge;
		if (x == serviceCharge)
			ppr.setPensionStatusCode(10);

		else {
			ppr.setPensionStatusCode(21);

		}

		return ppr;
	}

}
