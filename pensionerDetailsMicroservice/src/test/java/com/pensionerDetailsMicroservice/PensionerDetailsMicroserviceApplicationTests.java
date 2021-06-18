package com.pensionerDetailsMicroservice;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pensionerDetailsMicroservice.Exception.NotFoundException;

@SpringBootTest
class PensionerDetailsMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	/**
	 * testing mainMethod
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws NotFoundException
	 * @throws ParseException
	 */

	@Test
	void testMainMethod() throws NumberFormatException, IOException, NotFoundException, ParseException {
		PensionerDetailsMicroserviceApplication.main(new String[] {});
	}

}
