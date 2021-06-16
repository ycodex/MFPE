package com.pensionerDetailsMicroservice.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import com.opencsv.bean.CsvToBeanBuilder;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;

@Component
@Slf4j
public class csvToBean {

	public List<PensionerDetail> getData() throws IllegalStateException, FileNotFoundException {

		log.info("reading data from csv file");
		Reader reader = new InputStreamReader(this.getClass().getResourceAsStream("/Pensionerdetails.csv"));
		List<PensionerDetail> details = new CsvToBeanBuilder(reader).withType(PensionerDetail.class).build().parse();
		log.info("done reading data from csv file");
		log.info("returning the List");
		return details;

	}

}