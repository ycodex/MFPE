<<<<<<< HEAD
package com.pensionerDisbursementMicroservice.service;

import com.pensionerDisbursementMicroservice.Model.Bank;
import com.pensionerDisbursementMicroservice.Model.ProcessPensionResponse;

public interface PensionDisbursmentService {
	public ProcessPensionResponse code(Bank bank, double serviceCharge);
}
=======
package com.pensionerDisbursementMicroservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pensionerDisbursementMicroservice.Model.Bank;
import com.pensionerDisbursementMicroservice.Model.ProcessPensionResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PensionDisbursmentService {
	
	@Value("${public.bankcharge}")
	private double publicBankCharge;
	@Value("${private.bankcharge}")
	private double privateBankcharge;
	
	public ProcessPensionResponse code(Bank bank, double serviceCharge) {
		ProcessPensionResponse ppr = new ProcessPensionResponse();
		log.info("Returning the Service Charge based on bank type");
		double x = bank.getBankType().equalsIgnoreCase("public") ? publicBankCharge : privateBankcharge;
		if (x == serviceCharge) {
			ppr.setPensionStatusCode(10);
			log.info("Returning the success status code");
		}
		else {
			ppr.setPensionStatusCode(21);
			log.info("Returning the redo calculation status code");

		}
		log.info("Returned the service charge");
		return ppr;
	}

}
>>>>>>> 36d564dbfe4a3946ee3935933a0ed6a2cb99255d
