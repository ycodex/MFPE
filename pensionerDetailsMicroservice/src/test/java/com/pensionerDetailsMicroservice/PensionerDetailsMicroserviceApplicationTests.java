<<<<<<< HEAD
package com.pensionerDetailsMicroservice;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pensionerDetailsMicroservice.Exception.NotFoundException;
import com.pensionerDetailsMicroservice.Model.Bank;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
class PensionerDetailsMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	
	@Test
	void testMainMethod() throws NumberFormatException, IOException, NotFoundException, ParseException {
		PensionerDetailsMicroserviceApplication.main(new String [] {});
	}

}
=======
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
>>>>>>> 36d564dbfe4a3946ee3935933a0ed6a2cb99255d
