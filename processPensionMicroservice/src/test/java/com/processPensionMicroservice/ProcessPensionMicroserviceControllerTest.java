package com.processPensionMicroservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.processPensionMicroservice.controller.processPensionController;
import com.processPensionMicroservice.model.PensionDetail;
import com.processPensionMicroservice.model.PensionerInput;
import com.processPensionMicroservice.model.ProcessPensionInput;
import com.processPensionMicroservice.model.ProcessPensionResponse;
@SpringBootTest
public class ProcessPensionMicroserviceControllerTest {

	
	@Mock
	processPensionController processpensionController;
	
	@org.junit.Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}


	@org.junit.Test()
	public void testPost() throws Exception {
		
		PensionerInput p=new PensionerInput("Shubham",new Date("29/01/1999"),"PCASD1234Q",(long)123456789012.00,"self");
	
		PensionDetail r=new PensionDetail("Shubham",new Date("29/01/1999"),"PCASD1234Q","self",3150);
		
		when(processpensionController.getPensionDetails(p)).thenReturn(r);
	
		assertEquals(p.getName(),processpensionController.getPensionDetails(p).getName());
	       
	} 
	@org.junit.Test
	public void testGetCode() throws Exception {
		
		
		ProcessPensionInput pi=new ProcessPensionInput((long)123456789012.00,31500.00,550);
		when(processpensionController.getcode(pi)).thenReturn(new ProcessPensionResponse(10));
		assertEquals(10,processpensionController.getcode(pi).getPensionStatusCode());
	       
	} 
	
	

}
