package com.pensionerDetailsMicroservice.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.text.translate.CsvTranslators;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.exceptions.CsvException;
import com.pensionerDetailsMicroservice.Exception.NotFoundException;
import com.pensionerDetailsMicroservice.Model.Bank;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;
import com.pensionerDetailsMicroservice.Model.PensionerDetailCsv;
import com.pensionerDetailsMicroservice.Util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PensionerdetailService {

	private Map<Long, PensionerDetail> pensionDetails;

	public PensionerDetail getPensionerDetailByAadhaarNumber(long aadhaarNumber)
			throws IOException, NotFoundException, NumberFormatException, ParseException {
		String line = "";
		pensionDetails = new HashMap<>();
//		BufferedReader br = new BufferedReader(
//				new InputStreamReader(this.getClass().getResourceAsStream("/details.csv")));
//		while ((line = br.readLine()) != null) // returns a Boolean value
//		{
//			String[] person = line.split(",");
//			PensionerDetail pd = new PensionerDetail(person[1], DateUtil.parseDate(person[2]), person[3],
//					Double.parseDouble(person[4]), Double.parseDouble(person[5]), person[6],
//					new Bank(person[7], Long.parseLong(person[8]), person[9]));
//			pensionDetails.put(Long.parseLong(person[0]), pd);
//		}
		try {
		getDetails();
		}catch(Exception e) {
			//
		}
		log.info(pensionDetails.toString());
		if (pensionDetails.containsKey(aadhaarNumber)) {
			return pensionDetails.get(aadhaarNumber);
		} else {
			throw new NotFoundException("AadharNumber Not Found");
		}
	}

	

	public void getDetails() throws CsvException {
		// code to check aadhar number is valid or not

		// Bean attributes.
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("aadhar", "aadhar");
		mapping.put("name", "name");
		mapping.put("dateOfBirth", "dateOfBirth");
		mapping.put("pan", "pan");
		mapping.put("salary", "salary");
		mapping.put("allowance", "allowance");
		mapping.put("pensionType", "pensionType");
		mapping.put("accountNumber", "accountNumber");
		mapping.put("bankName", "bankName");
		mapping.put("bankType", "bankType");
		

		// HeaderColumnNameTranslateMappingStrategy
		HeaderColumnNameTranslateMappingStrategy<PensionerDetailCsv> strategy = new HeaderColumnNameTranslateMappingStrategy<PensionerDetailCsv>();
		strategy.setType(PensionerDetailCsv.class);
		strategy.setColumnMapping(mapping);

		// Create castobaen and csvreader object
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new InputStreamReader(this.getClass().getResourceAsStream("/details.csv")));
		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CsvToBean csvToBean = new CsvToBean();

		// call the parse method of CsvToBean
		// pass strategy, csvReader to parse method
		List<PensionerDetailCsv> list = csvToBean.parse(strategy, csvReader);
		log.info(list.toString());
		// print details of Bean object
		for (PensionerDetailCsv e : list) {
				PensionerDetail ps = new PensionerDetail();
				long aadhar=Long.parseLong(e.getAadhar());
				ps.setName(e.getName());
				String sDate1 = e.getDateOfBirth();
				Date date1 = null;
				try {
					date1 = new SimpleDateFormat("dd-MM-yyyy").parse(sDate1);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ps.setDateOfBirth(date1);
				ps.setPan(e.getPan());
				ps.setSalary(Integer.parseInt(e.getSalary()));
				ps.setPensionType(e.getPensionType());
				ps.setAllowance(Double.parseDouble(e.getAllowance()));
				Bank b = new Bank(e.getBankName(), Long.parseLong(e.getAccountNumber()), e.getBankType());
				ps.setBank(b);
				pensionDetails.put(aadhar,ps);
		}
			
	}



}
