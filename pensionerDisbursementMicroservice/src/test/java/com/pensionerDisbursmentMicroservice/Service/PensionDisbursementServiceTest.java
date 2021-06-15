package com.pensionerDisbursmentMicroservice.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pensionerDisbursementMicroservice.Model.Bank;
import com.pensionerDisbursementMicroservice.Model.ProcessPensionResponse;
import com.pensionerDisbursementMicroservice.service.PensionDisbursmentService;
import static org.mockito.Mockito.when;



import static org.mockito.Mockito.any;

@SpringBootTest        
public class PensionDisbursementServiceTest {

	@Mock
	PensionDisbursmentService service;
	
	@Mock
	ProcessPensionResponse response;
	
	int serviceCharge = 500;
	 @Before
	  public void createMocks() {
	    MockitoAnnotations.initMocks(this);
	  }
	@Test
	public void testServiceObjectNotNull() {
		assertNotNull(service);
	}
	
	@Test
	public void testResponseObjectNotNull() {
		assertNotNull(response);
	}
	
	@Test
	public void testGettingCodeForPublicTypeBank() {
		
		Bank bank = new Bank("ICICI", 123456, "public");
		ProcessPensionResponse r=new ProcessPensionResponse(10); 
		when(service.code(bank, serviceCharge)).thenReturn(r);
		ProcessPensionResponse response = service.code(bank, serviceCharge);
		assertEquals(10, response.getPensionStatusCode());
	}
	
	@Test
	public void testGettingCodeForPrivateTypeBank() {
		Bank bank = new Bank("ICICI", 123456, "private");
		ProcessPensionResponse r=new ProcessPensionResponse(21);
		when(service.code(bank, serviceCharge)).thenReturn(r);
		ProcessPensionResponse response = service.code(bank, serviceCharge);
		assertEquals(21, response.getPensionStatusCode());
	}

}
