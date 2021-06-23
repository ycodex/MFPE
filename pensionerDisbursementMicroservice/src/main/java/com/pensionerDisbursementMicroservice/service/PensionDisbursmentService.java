package com.pensionerDisbursementMicroservice.service;

import com.pensionerDisbursementMicroservice.Model.Bank;
import com.pensionerDisbursementMicroservice.Model.ProcessPensionResponse;

public interface PensionDisbursmentService {
	public ProcessPensionResponse code(Bank bank, double serviceCharge);
}
