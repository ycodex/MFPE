package com.processPensionMicroservice.service;

import com.processPensionMicroservice.model.PensionDetail;
import com.processPensionMicroservice.model.PensionerDetail;
import com.processPensionMicroservice.model.PensionerInput;
import com.processPensionMicroservice.model.ProcessPensionResponse;

public interface ProcessPensionService {
	 PensionDetail getresult(PensionerDetail pd);
	 ProcessPensionResponse checkdetails(PensionerInput pi, PensionerDetail pd);
}
