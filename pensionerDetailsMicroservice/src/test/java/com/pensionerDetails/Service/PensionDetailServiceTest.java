package com.pensionerDetails.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pensionerDetailsMicroservice.Exception.NotFoundException;
import com.pensionerDetailsMicroservice.Model.Bank;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;
import com.pensionerDetailsMicroservice.Service.PensionerDetailService;
import com.pensionerDetailsMicroservice.Util.DateUtil;

@SpringBootTest
public class PensionDetailServiceTest {

	@Mock
	private PensionerDetailService pds;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNotNullPensionDetailServiceObject() {
		assertNotNull(pds);
	}

	/**
	 * testing ForCorrectDetailsReturnedFromServiceWithCorrectAadharNumber
	 * 
	 * @throws IOException
	 * @throws NotFoundException
	 * @throws NumberFormatException
	 * @throws com.pensionerDetailsMicroservice.Exception.NotFoundException
	 * @throws ParseException
	 */

	@Test()
	public void testCorrectDetailsReturnedFromServiceWithCorrectAadharNumber() throws IOException, NotFoundException,
			NumberFormatException, com.pensionerDetailsMicroservice.Exception.NotFoundException, ParseException {

		PensionerDetail pensionerDetail = new PensionerDetail("Vaibhav", DateUtil.parseDate("26-11-1998"), "PCQAZ1285Q",
				30000, 12000, "family", new Bank("SBI", 12345679, "public"));
		when(pds.getPensionerDetailByAadhaarNumber(123456789013L)).thenReturn(pensionerDetail);
		assertEquals(pensionerDetail, pds.getPensionerDetailByAadhaarNumber(123456789013L));
	}

	/**
	 * testing ForIncorrectAadharNumber
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws NotFoundException
	 * @throws ParseException
	 */

	@Test()
	public void testForIncorrectAadharNumber()
			throws NumberFormatException, IOException, NotFoundException, ParseException {

		pds.getPensionerDetailByAadhaarNumber(12345678);
	}

}
