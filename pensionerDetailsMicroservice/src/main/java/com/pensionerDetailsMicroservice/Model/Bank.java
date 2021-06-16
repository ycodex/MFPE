package com.pensionerDetailsMicroservice.Model;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bank {
	@CsvBindByName(column = "BANK_NAME")
	private String bankName;
	
	@CsvBindByName(column = "ACC_NO")
	private long accountNumber;
	
	@CsvBindByName(column = "BANK_TYPE")
	private String bankType;
	
	
}
