package com.pensionerDisbursmentMicroservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pensionerDisbursementMicroservice.PensionerDisbursmentMicroserviceApplication;


@SpringBootTest(classes = {com.pensionerDisbursementMicroservice.PensionerDisbursmentMicroserviceApplication.class})
class PensionerDisbursmentMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void applicationStarts() {
		PensionerDisbursmentMicroserviceApplication.main(new String[] {});
	}

}
