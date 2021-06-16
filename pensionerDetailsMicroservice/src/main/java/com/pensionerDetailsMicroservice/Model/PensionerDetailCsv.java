package com.pensionerDetailsMicroservice.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PensionerDetailCsv {
	private String aadhar;
	private String name;
	private String dateOfBirth;
	private String pan;
	private String salary;
	private String allowance;
	private String pensionType;
	private String bankName;
	private String accountNumber;
	private String bankType;

}
